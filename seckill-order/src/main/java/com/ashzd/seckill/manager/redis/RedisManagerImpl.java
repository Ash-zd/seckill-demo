package com.ashzd.seckill.manager.redis;

import com.alibaba.fastjson.JSON;
import com.ashzd.seckill.common.constant.RedisConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @file: RedisServiceImpl
 * @author: Ash
 * @date: 2019/8/8 1:18
 * @description:
 * @since:
 */
@Service
public class RedisManagerImpl implements RedisManager {

    private static final Logger logger = LoggerFactory.getLogger(RedisManagerImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public <T> T get(String key, Class<T> clazz) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return JSON.parseObject(value, clazz);
    }

    @Override
    public <T> T getAndSet(String key, String value, Class<T> clazz) {
        return getAndSet(key, value, clazz, 2L, TimeUnit.HOURS);
    }

    @Override
    public <T> T getAndSet(String key, String value, Class<T> clazz, long time, TimeUnit unit) {
        String str = stringRedisTemplate.opsForValue().getAndSet(key, value);
        stringRedisTemplate.expire(key, time, unit);
        return JSON.parseObject(str, clazz);
    }

    @Override
    public <T> T getAndRefreshExpireTime(String key, Class<T> clazz) {
        refresh(key, RedisConstant.REDIS_DEFAULT_EXPIRE_TIME, RedisConstant.REDIS_DEFAULT_EXPIRE_TIME_UNIT);
        return get(key, clazz);
    }

    @Override
    public boolean refresh(String key, long time, TimeUnit unit) {
        return stringRedisTemplate.expire(key, time, unit);
    }

    @Override
    public <T> boolean set(String key, T value, long time, TimeUnit unit) {
        try {
            String json = JSON.toJSONString(value);
            stringRedisTemplate.opsForValue().set(key, json, time, unit);
        } catch (Exception e) {
            logger.debug("set value in redis failed", e);
            return false;
        }
        return true;
    }

    @Override
    public <T> boolean set(String key, T value) {
        return set(key, value, RedisConstant.REDIS_DEFAULT_EXPIRE_TIME, RedisConstant.REDIS_DEFAULT_EXPIRE_TIME_UNIT);
    }

    @Override
    public boolean isExist(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    @Override
    public boolean delete(String key) {
        return stringRedisTemplate.delete(key);
    }

    @Override
    public boolean decrease(String key) {
        return stringRedisTemplate.opsForValue().decrement(key) != null;
    }

    @Override
    public boolean increase(String key) {
        return stringRedisTemplate.opsForValue().increment(key) != null;
    }
}
