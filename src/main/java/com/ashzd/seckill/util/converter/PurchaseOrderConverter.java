package com.ashzd.seckill.util.converter;

import com.ashzd.seckill.entity.PurchaseOrder;

import java.util.Date;

/**
 * @file: PurchaseOrderConverter
 * @author: Ash
 * @date: 2019/7/23 16:05
 * @description:
 * @since:
 **/
public class PurchaseOrderConverter {

    public static PurchaseOrder toPurchaseOrder(String indexCode, Integer customerId, Integer storeId) {
        PurchaseOrder order = new PurchaseOrder();
        order.setCustomerId(customerId);
        order.setIndexCode(indexCode);
        order.setStoreId(storeId);
        order.setCreatedAt(new Date());
        order.setUpdatedAt(new Date());
        return order;
    }

}
