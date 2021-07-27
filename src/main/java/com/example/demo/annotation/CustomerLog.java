package com.example.demo.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author qzp
 * @Description: 日志记录注解
 * @date 2021/7/26 17:31
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface CustomerLog {

    /**
     * 日志描述，这里使用了@AliasFor 别名。spring提供的
     */
    String value() default "";

    /**
     * 是否不记录日志(false不记录)
     * @return
     */
    boolean ignore() default false;
}
