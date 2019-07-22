package com.ashzd.seckill.service.impl;

import com.ashzd.seckill.dto.OrderDTO;
import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.page.OrderPageReq;
import com.ashzd.seckill.dto.req.OrderReq;
import com.ashzd.seckill.mapper.OrderMapper;
import com.ashzd.seckill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @file: OrderServiceImpl
 * @author: Ash
 * @date: 2019/7/22 19:39
 * @description:
 * @since:
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void add(OrderReq orderReq, UserDTO userDTO) {
        Assert.notNull(orderReq, "订单信息为空");
        Assert.notNull(orderReq.getStoreId(), "店铺编号为空");
        Assert.notNull(orderReq.getProductId(), "商品编号为空");


    }

    @Override
    public List<OrderDTO> query(OrderPageReq orderPageReq) {
        return null;
    }
}
