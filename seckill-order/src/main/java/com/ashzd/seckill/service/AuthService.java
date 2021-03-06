package com.ashzd.seckill.service;

import com.ashzd.seckill.dto.req.LoginReq;

/**
 * @file: AuthService
 * @author: Ash
 * @date: 2019/7/14 13:41
 * @description:
 * @since:
 **/
public interface AuthService {

    String getTokenByUserId(Integer userId);

    String getTokenByUsername(String username);

    String getUsernameFromCacheByToken(String token);

    String getTokenByUsernameAndPassword(LoginReq loginReq);

}
