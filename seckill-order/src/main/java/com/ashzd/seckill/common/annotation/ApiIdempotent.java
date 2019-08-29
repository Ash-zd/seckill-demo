package com.ashzd.seckill.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @file: ApiIdempotent
 * @author: Ash
 * @date: 2019/8/29 0:37
 * @description:
 * @since:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIdempotent {

    String username();

    long expire();

    TimeUnit unit();

}
