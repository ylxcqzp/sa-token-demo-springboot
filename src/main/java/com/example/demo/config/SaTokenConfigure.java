package com.example.demo.config;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForStyle;
import cn.dev33.satoken.stp.StpLogic;
import com.example.demo.interceptor.FangShuaInterceptor;
import com.example.demo.interceptor.MySaRouteInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author qzp
 * @Description:
 * @date 2021/7/29 9:44
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    @Autowired
    private FangShuaInterceptor fangShuaInterceptor;
    @Autowired
    private MySaRouteInterceptor mySaRouteInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mySaRouteInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/doLogin");
        registry.addInterceptor(fangShuaInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/doLogin","/register");
    }

    /**
     * 跨域请求处理
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .maxAge(3600);
    }

    //Style 模式：Token 风格替换
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForStyle();
    }
}
