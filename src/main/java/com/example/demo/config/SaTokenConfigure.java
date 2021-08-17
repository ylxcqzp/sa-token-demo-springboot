package com.example.demo.config;

import com.example.demo.interceptor.FangShuaInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author qzp
 * @Description: todo
 * @date 2021/7/29 9:44
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    @Autowired
    private FangShuaInterceptor fangShuaInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(fangShuaInterceptor);
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
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
