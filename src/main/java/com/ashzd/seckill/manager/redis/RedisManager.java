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

    <T> boolean set(String key, T value, long time, TimeUnit unit);

    <T> boolean set(String key, T value);

    boolean isExist(String key);

    boolean delete(String key);
}
