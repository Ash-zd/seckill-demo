package com.ashzd.seckill.service.impl;

import com.ashzd.seckill.dto.req.LoginReq;
import com.ashzd.seckill.manager.redis.RedisManager;
import com.ashzd.seckill.service.AuthService;
import com.ashzd.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    private RedisManager redisManager;
    @Autowired
    private UserService userService;


    @Override
    public String getTokenByUserId(Integer userId) {
        String token = UUID.randomUUID().toString().replace("-", "");
        redisManager.set(token, userId);
        return token;
    }

    @Override
    public String getTokenByUsername(String username) {
        String token = UUID.randomUUID().toString().replace("-", "");
        redisManager.set(token, username);
        return token;
    }

    @Override
    public String getUsernameFromCacheByToken(String token) {
        return redisManager.get(token, String.class);
    }

    @Override
    public String getTokenByUsernameAndPassword(LoginReq loginReq) {
        String username = loginReq.getUsername();
        String password = loginReq.getPassword();
        if (userService.authUsernameAndPassword(username, password)) {
            if (redisManager.isExist(username)) {
                return redisManager.getAndRefreshExpireTime(username, String.class);
            } else {
                String token = this.getTokenByUsername(username);
                redisManager.set(username, token);
                return token;
            }
        } else {
            throw new RuntimeException("auth username and password failed", new Throwable());
        }
    }
}
