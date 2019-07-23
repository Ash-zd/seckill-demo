package com.ashzd.seckill.util.converter;

import com.ashzd.seckill.dto.PurchaseOrderDetailDTO;
import com.ashzd.seckill.entity.PurchaseOrderDetail;

import java.util.Date;

/**
 * @file: PurchaseOrderDetailConverter
 * @author: Ash
 * @date: 2019/7/23 15:54
 * @description:
 * @since:
 **/
public class PurchaseOrderDetailConverter {

    public static PurchaseOrderDetail toPurchaseOrderDetail(PurchaseOrderDetailDTO orderDetailDTO) {
        PurchaseOrderDetail orderDetail = new PurchaseOrderDetail();
        orderDetail.setPurchaseOrderIndexCode(orderDetailDTO.getOrderIndexCode());
        orderDetail.setProductId(orderDetailDTO.getProductId());
        orderDetail.setProductName(orderDetailDTO.getProductName());
        orderDetail.setProductDescription(orderDetailDTO.getProductDescription());
        orderDetail.setProductQuantity(orderDetailDTO.getProductQuantity());
        orderDetail.setProductUnitPrice(orderDetailDTO.getProductUnitPrice());
        orderDetail.setCreatedAt(new Date());
        orderDetail.setUpdatedAt(new Date());
        return orderDetail;
    }
}
