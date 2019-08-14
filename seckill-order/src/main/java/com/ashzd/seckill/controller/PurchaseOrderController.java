package com.ashzd.seckill.controller;

import com.ashzd.seckill.controller.common.BaseController;
import com.ashzd.seckill.dto.common.ResponseData;
import com.ashzd.seckill.dto.req.PurchaseOrderReq;
import com.ashzd.seckill.service.PurchaseOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @file: OrderController
 * @author: Ash
 * @date: 2019/7/22 19:35
 * @description:
 * @since:
 **/
@RestController
@RequestMapping("/v1/api/order")
public class PurchaseOrderController extends BaseController {

    @Autowired
    private PurchaseOrderService orderService;

    @ApiOperation(value = "新增订单")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseData addOrder(@RequestBody PurchaseOrderReq orderReq, HttpServletRequest request) {
        orderService.add(orderReq, getCurrentUserDTO(request));
        return ResponseData.success();
    }
}
