package com.example.demo.interceptor;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qzp
 * @Description: todo
 * @date 2022/1/20 16:54
 */
@Component
public class MySaRouteInterceptor extends SaRouteInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*options请求不带请求头，直接放行*/
        String method = request.getMethod();
        if (HttpMethod.OPTIONS.toString().equals(method)) {
            return true;
        }
        String token = request.getHeader("Access-Token");
        if (token != null) {
            String loginId = (String) StpUtil.getLoginIdByToken(token);
            return StrUtil.isNotEmpty(loginId);
        }
        return false;
    }
}
