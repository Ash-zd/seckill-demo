package com.ashzd.seckill.util.converter;

import com.ashzd.seckill.dto.req.ProductReq;
import com.ashzd.seckill.entity.Product;

import java.util.Date;

/**
 * @file: ProductConverter
 * @author: Ash
 * @date: 2019/7/22 20:43
 * @description:
 * @since:
 **/
public class ProductConverter {

    public static Product toProduct(ProductReq productReq) {
        Product product = new Product();
        product.setStoreId(productReq.getStoreId());
        product.setName(productReq.getName());
        product.setDescription(productReq.getDescription());
        product.setPrice(productReq.getPrice());
        product.setQuantity(productReq.getQuantity());
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());
        return product;
    }

}
