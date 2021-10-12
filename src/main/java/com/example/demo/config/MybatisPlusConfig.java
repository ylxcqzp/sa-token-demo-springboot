package com.example.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qzp
 * @Description: mybatisPlus配置
 * @date 2021/10/12 16:02
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页配置
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
