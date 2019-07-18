package com.ashzd.seckill.config.fastjson;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @file: FastJsonConfig
 * @author: Ash
 * @date: 2019/7/18 23:42
 * @description:
 * @since:
 **/
@Configuration
public class FastJsonConfig {

    /**
     * 在 Spring Data Redis 中集成 Fastjson
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        GenericFastJsonRedisSerializer fastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
        // 设置默认的Serialize，包含 keySerializer & valueSerializer
        redisTemplate.setDefaultSerializer(fastJsonRedisSerializer);
        // 单独设置keySerializer
        // redisTemplate.setKeySerializer(fastJsonRedisSerializer);
        // 单独设置valueSerializer
        // redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        return redisTemplate;
    }

}
