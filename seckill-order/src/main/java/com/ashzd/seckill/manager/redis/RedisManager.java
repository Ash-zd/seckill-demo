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
    <T> T get(String key, Class<T> clazz);

    <T> T getAndSet(String key, String value, Class<T> clazz);

    <T> T getAndSet(String key, String value, Class<T> clazz, long time, TimeUnit unit);

    <T> T getAndRefreshExpireTime(String key, Class<T> clazz);

    boolean refresh(String key, long time, TimeUnit unit);

    <T> boolean set(String key, T value, long time, TimeUnit unit);

    <T> boolean set(String key, T value);

    boolean isExist(String key);

    boolean delete(String key);

    boolean decrease(String key);

    boolean increase(String key);

}
