package com.ashzd.seckill.service.impl;

import com.ashzd.seckill.dto.StoreDTO;
import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.page.StorePageReq;
import com.ashzd.seckill.dto.req.StoreReq;
import com.ashzd.seckill.entity.Store;
import com.ashzd.seckill.entity.StoreExample;
import com.ashzd.seckill.mapper.StoreMapper;
import com.ashzd.seckill.service.StoreService;
import com.ashzd.seckill.util.CollectionUtil;
import com.ashzd.seckill.util.StringUtil;
import com.ashzd.seckill.util.converter.StoreConverter;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @file: StoreServiceImpl
 * @author: Ash
 * @date: 2019/7/22 19:39
 * @description:
 * @since:
 **/
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public void add(StoreReq storeReq, UserDTO userDTO) {
        // 参数校验
        Assert.notNull(storeReq, "店铺信息为空");
        Assert.isTrue(StringUtil.isNotBlank(storeReq.getName()), "店铺名称为空");
        Assert.isTrue(StringUtil.isNotBlank(storeReq.getDescription()), "店铺描述为空");
        // 逻辑校验
        Assert.isTrue(this.isStoreNameAndOwnerDuplicate(storeReq.getName(), userDTO.getUserId()), "该用户已存在同名店铺");
        Store store = StoreConverter.toStore(storeReq);
        storeMapper.insertSelective(store);
    }

    private boolean isStoreNameAndOwnerDuplicate(String name, Integer ownerId) {
        StoreExample example = new StoreExample();
        example.createCriteria().andOwnerIdEqualTo(ownerId).andNameEqualTo(name);
        List<Store> stores = storeMapper.selectByExample(example);
        return !CollectionUtil.isEmpty(stores);
    }

    @Override
    public void update(StoreReq storeReq, UserDTO userDTO) {
        // 参数校验
        Assert.notNull(storeReq, "店铺信息为空");
        Assert.notNull(storeReq.getId(), "店铺编号为空");
        Store store = storeMapper.selectByPrimaryKey(storeReq.getId());
        if (StringUtil.isNotBlank(storeReq.getName())) {
            Assert.isTrue(this.isStoreNameAndOwnerDuplicate(storeReq.getName(), userDTO.getUserId()), "该用户已存在同名店铺");
            store.setName(storeReq.getName());
        }
        if (StringUtil.isNotBlank(storeReq.getDescription())) {
            store.setDescription(storeReq.getDescription());
        }
        store.setUpdatedAt(new Date());
        storeMapper.updateByPrimaryKey(store);
    }

    @Override
    public void delete(StoreReq storeReq, UserDTO userDTO) {
        // 参数校验
        Assert.notNull(storeReq, "店铺信息为空");
        Assert.notNull(storeReq.getId(), "店铺编号为空");
        Store store = storeMapper.selectByPrimaryKey(storeReq.getId());
        Assert.isTrue(store.getId().equals(userDTO.getUserId()), "店铺权限校验失败");
        storeMapper.deleteByPrimaryKey(store.getId());
    }

    @Override
    public List<StoreDTO> query(StorePageReq storePageReq) {
        // 参数校验
        Assert.notNull(storePageReq, "搜索条件为空");
        Assert.notNull(storePageReq.getName(), "搜索条件为空");
        int pageNo = Objects.isNull(storePageReq.getPageNo()) ? 1 : storePageReq.getPageNo();
        int pageSize = Objects.isNull(storePageReq.getPageSize()) ? 10 : storePageReq.getPageSize();
        PageHelper.startPage(pageNo, pageSize);
        StoreExample example = new StoreExample();
        example.createCriteria().andNameLike("%" + storePageReq.getName() + "%");
        List<Store> storeList = storeMapper.selectByExample(example);
        return storeList.stream().map(StoreConverter::toStoreDTO).collect(Collectors.toList());
    }

    @Override
    public boolean isUserOwnStore(Integer storeId, Integer userId) {
        Assert.notNull(storeId, "店铺编号为空");
        Assert.notNull(userId, "用户编号为空");
        Store store = storeMapper.selectByPrimaryKey(storeId);
        return store.getOwnerId().equals(userId);
    }
}
