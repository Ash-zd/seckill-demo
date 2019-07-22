package com.ashzd.seckill.service;

import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.req.UserReq;
import com.ashzd.seckill.entity.User;

/**
 * @file: UserService
 * @author: Ash
 * @date: 2019/7/13 21:23
 * @description:
 * @since:
 **/
public interface UserService {

    UserDTO getUserById(Integer userId);

    UserDTO getUserDTOByUsername(String username);

    User getUserByUsername(String username);

    void addUser(UserReq userReq);

    boolean authUsernameAndPassword(String username, String password);

}
