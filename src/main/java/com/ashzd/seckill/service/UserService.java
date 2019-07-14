package com.ashzd.seckill.service;

import com.ashzd.seckill.dto.req.UserReqDTO;
import com.ashzd.seckill.entity.User;

/**
 * @file: UserService
 * @author: Ash
 * @date: 2019/7/13 21:23
 * @description:
 * @since:
 **/
public interface UserService {


    User getUserById(Integer userId);

    User getUserByUsername(String username);

    void addUser(UserReqDTO userReqDTO);

}
