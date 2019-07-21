package com.ashzd.seckill.controller;

import com.ashzd.seckill.controller.common.BaseController;
import com.ashzd.seckill.dto.common.ResponseData;
import com.ashzd.seckill.dto.req.UserReqDTO;
import com.ashzd.seckill.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @file: UserController
 * @author: Ash
 * @date: 2019/7/13 18:15
 * @description:
 * @since:
 **/
@RestController
@RequestMapping("/v1/api/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseData add(@RequestBody UserReqDTO userReqDTO) {
        userService.addUser(userReqDTO);
        return ResponseData.success();
    }

}
