package com.ashzd.seckill.controller;

import com.ashzd.seckill.dto.common.ResponseData;
import com.ashzd.seckill.dto.req.LoginReqDTO;
import com.ashzd.seckill.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @file: AuthController
 * @author: Ash
 * @date: 2019/7/13 21:39
 * @description:
 * @since:
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(@RequestBody LoginReqDTO loginReqDTO) {
        return ResponseData.success(authService.getTokenByUsernameAndPassword(loginReqDTO));
    }

}
