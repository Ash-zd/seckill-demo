package com.ashzd.seckill.service;

import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.req.ProductReq;

/**
 * @file: ProductService
 * @author: Ash
 * @date: 2019/7/22 19:35
 * @description:
 * @since:
 **/
public interface ProductService {

    void add(ProductReq productReq, UserDTO userDTO);

    void decrease(Integer productId, Integer quantity);

    boolean isStoreOwnProduct(Integer storeId, Integer productId);

}
