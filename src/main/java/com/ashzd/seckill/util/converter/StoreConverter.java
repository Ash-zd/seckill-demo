package com.ashzd.seckill.util.converter;

import com.ashzd.seckill.dto.StoreDTO;
import com.ashzd.seckill.dto.req.StoreReq;
import com.ashzd.seckill.entity.Store;

/**
 * @file: StoreConverter
 * @author: Ash
 * @date: 2019/7/22 19:46
 * @description:
 * @since:
 **/
public class StoreConverter {

    public static Store toStore(StoreReq storeReq) {
        Store store = new Store();
        store.setName(storeReq.getName());
        store.setDescription(storeReq.getDescription());
        return store;
    }

    public static StoreDTO toStoreDTO(Store store) {
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setName(store.getName());
        storeDTO.setDescription(store.getDescription());
        return storeDTO;
    }
}
