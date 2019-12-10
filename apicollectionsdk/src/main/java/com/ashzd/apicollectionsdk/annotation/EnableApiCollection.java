package com.ashzd.apicollectionsdk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @file: EnableApiCollection
 * @author: Ash
 * @date: 2019/10/22 13:46
 * @description:
 * @since:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableApiCollection {

}
