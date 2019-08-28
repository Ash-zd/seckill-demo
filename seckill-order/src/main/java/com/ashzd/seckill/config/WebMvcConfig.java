package com.ashzd.seckill.config;

import com.ashzd.seckill.common.interceptor.RateLimiterInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @file: WebMvcConfig
 * @author: Ash
 * @date: 2019/8/27 19:32
 * @description:
 * @since:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private RateLimiterInterceptor rateLimiterInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rateLimiterInterceptor).addPathPatterns("/v1/api/order/seckill");
    }
}
