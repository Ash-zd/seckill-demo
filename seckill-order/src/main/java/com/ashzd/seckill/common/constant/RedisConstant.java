package com.ashzd.seckill.common.constant;

import java.util.concurrent.TimeUnit;

/**
 * @file: RedisConstant
 * @author: Ash
 * @date: 2019/8/8 15:13
 * @description:
 * @since:
 */
public class RedisConstant {
    public static final long REDIS_DEFAULT_EXPIRE_TIME = 2L;
    public static final TimeUnit REDIS_DEFAULT_EXPIRE_TIME_UNIT = TimeUnit.HOURS;

    // prefix
    public static final String USER_TOKEN_PREFIX = "token:";
    public static final String PRODUCT_QUANTITY_PREFIX = "product_quantity:";
    public static final String USER_REQUEST_TOKEN_PREFIX = "user_request:";
    public static final String LOGIN_USERNAME_PREFIX = "login_user:";


}
