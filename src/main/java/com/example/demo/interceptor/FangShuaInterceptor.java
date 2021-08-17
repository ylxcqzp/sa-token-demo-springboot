package com.example.demo.interceptor;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import com.example.demo.annotation.AccessLimit;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author qzp
 * @Description: 接口防刷拦截器
 * @date 2021/7/29 9:29
 */
@Component
public class FangShuaInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //是否为方法请求
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AccessLimit accessLimit = handlerMethod.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
            int maxCount = accessLimit.maxCount();
            int seconds = accessLimit.seconds();
            boolean needLogin = accessLimit.needLogin();
            String key = request.getRequestURI();
            if (needLogin) {
                String userId = StpUtil.getLoginIdAsString();
                key += userId;
            }
            Object value = redisUtil.get(key);
            if (value == null) {
                redisUtil.set(key,1,seconds);
                return true;
            }
            Integer count = Integer.parseInt(value.toString());
            if (count < maxCount) {
                redisUtil.incr(key,1);
            }else {
                //todo 对返回信息封装
                render(response,"接口限制访问");
                return false;
            }
        }
        return true;
    }

    private void render(HttpServletResponse response, String message) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        out.write(message.getBytes(StandardCharsets.UTF_8));
        out.flush();
        out.close();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
