package com.ashzd.apicollectionsdk.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @file: ApiCollectionAOP
 * @author: Ash
 * @date: 2019/10/22 13:51
 * @description:
 * @since:
 */
@Component
@Aspect
@Order(-1)
public class ApiCollectionAOP {

    @Pointcut("@annotation(com.ashzd.apicollectionsdk.annotation.EnableApiCollection)")
    public void apiCollection(){}




}