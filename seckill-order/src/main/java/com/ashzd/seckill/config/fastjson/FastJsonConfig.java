package com.ashzd.seckill.config.fastjson;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @file: FastJsonConfig
 * @author: Ash
 * @date: 2019/7/18 23:42
 * @description:
 * @since:
 **/
@Configuration
public class FastJsonConfig implements WebMvcConfigurer {

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

    /**
     * 强制设定fastjson为默认序列化、反序列化converter
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        // 自定义配置...
//        FastJsonConfig config = new FastJsonConfig();
//        config.set ...
//        converter.setFastJsonConfig(config);
        converters.add(0, converter);
    }

}
