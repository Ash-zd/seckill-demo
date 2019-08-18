package com.ashzd.seckill.service;

import com.ashzd.seckill.dto.PurchaseOrderDTO;
import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.req.PurchaseOrderReq;
import com.ashzd.seckill.dto.req.SeckillReq;
import com.ashzd.seckill.dto.req.page.OrderPageReq;

import java.util.List;

/**
 * @file: PurchaseOrderService
 * @author: Ash
 * @date: 2019/7/22 19:35
 * @description:
 * @since:
 **/
public interface PurchaseOrderService {

    void add(PurchaseOrderReq orderReq, UserDTO userDTO);

    List<PurchaseOrderDTO> query(OrderPageReq orderPageReq);

    void seckill(SeckillReq seckillReq, UserDTO userDTO);

}
