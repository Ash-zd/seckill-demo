package com.ashzd.seckill.controller.common;

import com.ashzd.seckill.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @file: BaseController
 * @author: Ash
 * @date: 2019/7/13 16:11
 * @description:
 * @since:
 **/
public class BaseController {

    protected User getCurrentUser(HttpServletRequest request) {
        return null;
    }

}
