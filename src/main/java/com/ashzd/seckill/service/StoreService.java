package com.ashzd.seckill.service;

import com.ashzd.seckill.dto.StoreDTO;
import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.req.StoreReq;
import com.ashzd.seckill.dto.req.page.StorePageReq;

import java.util.List;

/**
 * @file: StoreService
 * @author: Ash
 * @date: 2019/7/22 19:34
 * @description:
 * @since:
 **/
public interface StoreService {

    void add(StoreReq storeReq, UserDTO userDTO);

    void update(StoreReq storeReq, UserDTO userDTO);

    void delete(StoreReq storeReq, UserDTO userDTO);

    List<StoreDTO> query(StorePageReq storePageReq);

    boolean isUserOwnStore(Integer storeId, Integer userId);
}
