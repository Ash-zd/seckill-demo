package com.ashzd.seckill.manager.redis;

import java.util.concurrent.TimeUnit;

/**
 * @file: RedisManager
 * @author: Ash
 * @date: 2019/8/8 1:18
 * @description:
 * @since:
 */
public interface RedisManager {
    <T> T get(String keyPrefix, String key, Class<T> clazz);

    <T> T getAndSet(String keyPrefix, String key, String value, Class<T> clazz);

    <T> T getAndSet(String keyPrefix, String key, String value, Class<T> clazz, long time, TimeUnit unit);

    <T> T getAndRefreshExpireTime(String keyPrefix, String key, Class<T> clazz);

    boolean refresh(String keyPrefix, String key, long time, TimeUnit unit);

    boolean refresh(String keyPrefix, String key);

    <T> boolean set(String keyPrefix, String key, T value, long time, TimeUnit unit);

    <T> boolean set(String keyPrefix, String key, T value);

    boolean isExist(String keyPrefix, String key);

    boolean isHashExist(String keyPrefix, String key, String hashKey);

    boolean isSetExist(String keyPrefix, String key, Object member);

    boolean delete(String keyPrefix, String key);

    boolean decrease(String keyPrefix, String key);

    boolean increase(String keyPrefix, String key);

}
