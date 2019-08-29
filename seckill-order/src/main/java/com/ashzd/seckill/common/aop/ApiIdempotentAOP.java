package com.ashzd.seckill.common.aop;

import com.ashzd.seckill.manager.redis.RedisManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @file: ApiIdempotentAOP
 * @author: Ash
 * @date: 2019/8/29 0:55
 * @description:
 * @since:
 */
@Component
@Aspect
@Order(-1)
public class ApiIdempotentAOP {

    @Autowired
    private RedisManager redisManager;

    @Pointcut("@annotation(com.ashzd.seckill.common.annotation.ApiIdempotent)")
    public void apiIdempotent() {
    }

    @Around("apiIdempotent()")
    public void aroundMethod(ProceedingJoinPoint joinPoint) {
        // 获取请求参数
//        String[] params = joinPoint.getStaticPart().getSignature().
        // 查看redis是否存在
        // 不存在则添加 过期时间为5min
        // 存在则报请求重复异常

    }

}
