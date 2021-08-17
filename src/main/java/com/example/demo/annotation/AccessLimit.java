package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author qzp
 * @Description: todo
 * @date 2021/7/29 9:22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AccessLimit {
    int seconds();

    int maxCount();

    boolean needLogin() default true;
}
