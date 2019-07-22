package com.ashzd.seckill.util.converter;

import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.req.UserReq;
import com.ashzd.seckill.entity.User;
import com.ashzd.seckill.util.BCryptUtil;

/**
 * @file: UserConverter
 * @author: Ash
 * @date: 2019/7/14 15:14
 * @description:
 * @since:
 **/
public class UserConverter {

    public static User toUser(UserReq userReq) {
        User user = new User();
        user.setUsername(userReq.getUsername());
        user.setPassword(BCryptUtil.encode(userReq.getPassword()));
        user.setEmail(userReq.getEmail());
        user.setIsUser(true);
        return user;
    }

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setUser(user.getIsUser());
        return userDTO;
    }

}
