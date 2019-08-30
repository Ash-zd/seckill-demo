package com.ashzd.seckill.controller;

import com.ashzd.seckill.common.annotation.ApiIdempotent;
import com.ashzd.seckill.controller.common.BaseController;
import com.ashzd.seckill.dto.common.ResponseData;
import com.ashzd.seckill.dto.req.LoginReq;
import com.ashzd.seckill.service.AuthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @file: AuthController
 * @author: Ash
 * @date: 2019/7/13 21:39
 * @description:
 * @since:
 **/
@RestController
@RequestMapping("/v1/api/auth")
public class AuthController extends BaseController {

    @Autowired
    private AuthService authService;

    @ApiIdempotent(expire = 5L, unit = TimeUnit.SECONDS)
    @ApiOperation(value = "登录", notes = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(@RequestBody LoginReq loginReq) {
        return ResponseData.success(authService.getTokenByUsernameAndPassword(loginReq));
    }

}
