package com.ashzd.seckill.service.impl;

import com.ashzd.seckill.dto.PurchaseOrderDTO;
import com.ashzd.seckill.dto.PurchaseOrderDetailDTO;
import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.req.PurchaseOrderReq;
import com.ashzd.seckill.dto.req.page.OrderPageReq;
import com.ashzd.seckill.entity.PurchaseOrder;
import com.ashzd.seckill.mapper.PurchaseOrderMapper;
import com.ashzd.seckill.service.ProductService;
import com.ashzd.seckill.service.PurchaseOrderDetailService;
import com.ashzd.seckill.service.PurchaseOrderService;
import com.ashzd.seckill.util.converter.PurchaseOrderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @file: OrderServiceImpl
 * @author: Ash
 * @date: 2019/7/22 19:39
 * @description:
 * @since:
 **/
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private PurchaseOrderDetailService orderDetailService;
    @Autowired
    private ProductService productService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(PurchaseOrderReq orderReq, UserDTO userDTO) {
        Assert.notNull(orderReq, "订单信息为空");
        Assert.notNull(orderReq.getStoreId(), "店铺编号为空");
        Assert.notEmpty(orderReq.getProducts(), "商品详情为空");
        Set<Integer> productIds = orderReq.getProducts().keySet();
        Assert.isTrue(productIds.stream().allMatch(id -> productService.isStoreOwnProduct(orderReq.getStoreId(), id)), "店铺不存在此商品");
        String orderIndexCode = UUID.randomUUID().toString().replace("-", "");
        // 生成订单详情
        List<PurchaseOrderDetailDTO> orderDetailDTOList = new ArrayList<>(productIds.size());
        productIds.forEach(id -> orderDetailDTOList.add(new PurchaseOrderDetailDTO(orderIndexCode, id, orderReq.getProducts().get(id))));
        BigDecimal totalPrice = new BigDecimal(0);
        for (PurchaseOrderDetailDTO orderDetailDTO : orderDetailDTOList) {
            totalPrice = totalPrice.add(orderDetailService.addAndReturnTotalPrice(orderDetailDTO));
        }
        // 生成订单
        PurchaseOrder order = PurchaseOrderConverter.toPurchaseOrder(orderIndexCode, userDTO.getUserId(), orderReq.getStoreId());
        order.setTotalPrice(totalPrice);
        purchaseOrderMapper.insertSelective(order);
    }

    @Override
    public List<PurchaseOrderDTO> query(OrderPageReq orderPageReq) {
        return null;
    }
}
