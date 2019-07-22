package com.ashzd.seckill.service.impl;

import com.ashzd.seckill.dto.req.LoginReq;
import com.ashzd.seckill.service.AuthService;
import com.ashzd.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @file: AuthServiceImpl
 * @author: Ash
 * @date: 2019/7/14 13:41
 * @description:
 * @since:
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;


    @Override
    public String getTokenByUserId(Integer userId) {
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set(token, userId, 2, TimeUnit.HOURS);
        return token;
    }

    @Override
    public String getTokenByUsername(String username) {
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set(token, username, 2, TimeUnit.HOURS);
        return token;
    }

    @Override
    public String getUsernameFromCacheByToken(String token) {
        return (String) redisTemplate.opsForValue().get(token);
    }

    @Override
    public String getTokenByUsernameAndPassword(LoginReq loginReq) {
        String username = loginReq.getUsername();
        String password = loginReq.getPassword();
        if (userService.authUsernameAndPassword(username, password)) {
            return this.getTokenByUsername(username);
        } else {
            throw new RuntimeException("auth username and password failed", new Throwable());
        }
    }
}
