package com.ashzd.seckill.service;

import com.ashzd.seckill.dto.OrderDTO;
import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.page.OrderPageReq;
import com.ashzd.seckill.dto.req.OrderReq;

import java.util.List;

/**
 * @file: OrderService
 * @author: Ash
 * @date: 2019/7/22 19:35
 * @description:
 * @since:
 **/
public interface OrderService {

    void add(OrderReq orderReq, UserDTO userDTO);

    List<OrderDTO> query(OrderPageReq orderPageReq);

}
