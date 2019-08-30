package com.ashzd.seckill.common.aop;

import com.alibaba.fastjson.JSON;
import com.ashzd.seckill.common.annotation.ApiIdempotent;
import com.ashzd.seckill.common.constant.AuthConstant;
import com.ashzd.seckill.common.constant.RedisConstant;
import com.ashzd.seckill.common.exception.CustomException;
import com.ashzd.seckill.manager.redis.RedisManager;
import com.ashzd.seckill.util.MD5Util;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取请求参数
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String token = request.getHeader(AuthConstant.AUTHORIZATION_HEADER);
        String[] reqParamNames = ((CodeSignature) joinPoint.getStaticPart().getSignature()).getParameterNames();
        Object[] reqParamValues = joinPoint.getArgs();
        Map<String, Object> param = new HashMap<>();
        param.put("token", token);
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        ApiIdempotent apiIdempotent = method.getAnnotation(ApiIdempotent.class);
        for (int i = 0; i < reqParamNames.length; i++) {
            param.put(reqParamNames[i], reqParamValues[i]);
        }
        // 生成md5数据
        String requestmd5 = MD5Util.encrypt(JSON.toJSONString(param));
        // 查看redis是否存在
        boolean exist = redisManager.isExist(RedisConstant.USER_REQUEST_TOKEN_PREFIX, requestmd5);
        if (!exist) {
            // 不存在则添加 过期时间为5min
            redisManager.set(RedisConstant.USER_REQUEST_TOKEN_PREFIX, requestmd5, "mark", apiIdempotent.expire(), apiIdempotent.unit());
        } else {
            // 存在则报请求重复异常
            throw new CustomException("重复请求，请稍后再试");
        }
        return joinPoint.proceed();
    }
}
