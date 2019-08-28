package com.ashzd.seckill.common.interceptor;

import com.ashzd.seckill.dto.common.ResponseData;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @file: RateLimiterInterceptor
 * @author: Ash
 * @date: 2019/8/27 19:18
 * @description:
 * @since:
 */
@Component
public class RateLimiterInterceptor extends AbstractInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RateLimiterInterceptor.class);

    private static final RateLimiter rateLimiter = RateLimiter.create(1000);

    @Override
    protected ResponseData preFilter(HttpServletRequest request) {
        if (!rateLimiter.tryAcquire()) {
            logger.debug("限流中");
            return ResponseData.failure("system is busy, please try again");
        } else {
            logger.debug("请求成功");
            return ResponseData.success();
        }
    }
}
