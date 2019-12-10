package com.ashzd.seckill.manager.redis;

import com.alibaba.fastjson.JSON;
import com.ashzd.seckill.common.constant.RedisConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public <T> T get(String keyPrefix, String key, Class<T> clazz) {
        String value = stringRedisTemplate.opsForValue().get(keyPrefix + key);
        return JSON.parseObject(value, clazz);
    }

    @Override
    public <T> T getAndSet(String keyPrefix, String key, String value, Class<T> clazz) {
        return getAndSet(keyPrefix, key, value, clazz, 2L, TimeUnit.HOURS);
    }

    @Override
    public <T> T getAndSet(String keyPrefix, String key, String value, Class<T> clazz, long time, TimeUnit unit) {
        String str = stringRedisTemplate.opsForValue().getAndSet(key, value);
        stringRedisTemplate.expire(keyPrefix + key, time, unit);
        return JSON.parseObject(str, clazz);
    }

    @Override
    public <T> T getAndRefreshExpireTime(String keyPrefix, String key, Class<T> clazz) {
        refresh(keyPrefix, key, RedisConstant.REDIS_DEFAULT_EXPIRE_TIME, RedisConstant.REDIS_DEFAULT_EXPIRE_TIME_UNIT);
        return get(keyPrefix, key, clazz);
    }

    @Override
    public boolean refresh(String keyPrefix, String key, long time, TimeUnit unit) {
        return stringRedisTemplate.expire(keyPrefix + key, time, unit);
    }

    @Override
    public boolean refresh(String keyPrefix, String key) {
        return refresh(keyPrefix, key, RedisConstant.REDIS_DEFAULT_EXPIRE_TIME, RedisConstant.REDIS_DEFAULT_EXPIRE_TIME_UNIT);
    }

    @Override
    public <T> boolean set(String keyPrefix, String key, T value, long time, TimeUnit unit) {
        try {
            String json = JSON.toJSONString(value);
            stringRedisTemplate.opsForValue().set(keyPrefix + key, json, time, unit);
        } catch (Exception e) {
            logger.debug("set value in redis failed", e);
            return false;
        }
        return true;
    }

    @Override
    public <T> boolean set(String keyPrefix, String key, T value) {
        return set(keyPrefix, key, value, RedisConstant.REDIS_DEFAULT_EXPIRE_TIME, RedisConstant.REDIS_DEFAULT_EXPIRE_TIME_UNIT);
    }

    @Override
    public boolean isExist(String keyPrefix, String key) {
        return stringRedisTemplate.hasKey(keyPrefix + key);
    }

    @Override
    public boolean isHashExist(String keyPrefix, String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(keyPrefix + key, hashKey);
    }

    @Override
    public boolean isSetExist(String keyPrefix, String key, Object member) {
        return redisTemplate.opsForSet().isMember(keyPrefix + key, member);
    }

    @Override
    public boolean delete(String keyPrefix, String key) {
        return stringRedisTemplate.delete(keyPrefix + key);
    }

    @Override
    public boolean decrease(String keyPrefix, String key) {
        return stringRedisTemplate.opsForValue().decrement(keyPrefix + key) >= 0;
    }

    @Override
    public boolean increase(String keyPrefix, String key) {
        return stringRedisTemplate.opsForValue().increment(keyPrefix + key) != null;
    }
}
