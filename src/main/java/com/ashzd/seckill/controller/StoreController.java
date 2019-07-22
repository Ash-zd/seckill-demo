package com.ashzd.seckill.controller;

import com.ashzd.seckill.controller.common.BaseController;
import com.ashzd.seckill.dto.common.ResponseData;
import com.ashzd.seckill.dto.page.StorePageReq;
import com.ashzd.seckill.dto.req.StoreReq;
import com.ashzd.seckill.service.StoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @file: StoreController
 * @author: Ash
 * @date: 2019/7/22 19:33
 * @description:
 * @since:
 **/
@RestController
@RequestMapping("/v1/api/store")
public class StoreController extends BaseController {

    @Autowired
    private StoreService storeService;

    @ApiOperation(value = "新增店铺")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData add(StoreReq storeReq, HttpServletRequest request) {
        storeService.add(storeReq, getCurrentUserDTO(request));
        return ResponseData.success();
    }

    @ApiOperation(value = "修改店铺")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseData update(StoreReq storeReq, HttpServletRequest request) {
        storeService.update(storeReq, getCurrentUserDTO(request));
        return ResponseData.success();
    }

    @ApiOperation(value = "查询店铺")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseData query(StorePageReq storePageReq) {
        storeService.query(storePageReq);
        return ResponseData.success();
    }


}
