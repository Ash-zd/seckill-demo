package com.ashzd.seckill.service.impl;

import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.req.UserReqDTO;
import com.ashzd.seckill.entity.User;
import com.ashzd.seckill.entity.UserExample;
import com.ashzd.seckill.mapper.UserMapper;
import com.ashzd.seckill.service.UserService;
import com.ashzd.seckill.util.BCryptUtil;
import com.ashzd.seckill.util.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @file: UserServiceImpl
 * @author: Ash
 * @date: 2019/7/13 21:23
 * @description:
 * @since:
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUserById(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return UserConverter.toUserDTO(user);
    }

    @Override
    public UserDTO getUserDTOByUsername(String username) {
        User user = this.getUserByUsername(username);
        return UserConverter.toUserDTO(user);
    }

    @Override
    public User getUserByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        Assert.notEmpty(users, "查询用户失败");
        return users.get(0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserReqDTO userReqDTO) {
        // 参数校验
        Assert.notNull(userReqDTO, "参数不能为null");
        Assert.notNull(userReqDTO.getUsername(), "用户名不能为null");
        Assert.notNull(userReqDTO.getPassword(), "密码不能为null");
        // 逻辑性校验
        UserDTO user = this.getUserDTOByUsername(userReqDTO.getUsername());
        Assert.isNull(user, "用户名已存在");
        // 保存数据库
        User dbUser = UserConverter.toUser(userReqDTO);
        userMapper.insertSelective(dbUser);
    }


    @Override
    public boolean authUsernameAndPassword(String username, String password) {
        User user = this.getUserByUsername(username);
        return BCryptUtil.match(password, user.getPassword());
    }
}
