package com.ashzd.seckill.controller;

import com.ashzd.seckill.controller.common.BaseController;
import com.ashzd.seckill.dto.common.ResponseData;
import com.ashzd.seckill.dto.req.ProductReq;
import com.ashzd.seckill.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @file: ProductController
 * @author: Ash
 * @date: 2019/7/22 19:33
 * @description:
 * @since:
 **/
@RestController
@RequestMapping("/v1/api/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "新增商品")
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData add(ProductReq productReq, HttpServletRequest request) {
        productService.add(productReq, getCurrentUserDTO(request));
        return ResponseData.success();
    }

}
