package com.ashzd.seckill.service.impl;

import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.req.ProductReq;
import com.ashzd.seckill.entity.Product;
import com.ashzd.seckill.entity.ProductExample;
import com.ashzd.seckill.mapper.ProductMapper;
import com.ashzd.seckill.service.ProductService;
import com.ashzd.seckill.service.StoreService;
import com.ashzd.seckill.util.CollectionUtil;
import com.ashzd.seckill.util.StringUtil;
import com.ashzd.seckill.util.converter.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * @file: ProductServiceImpl
 * @author: Ash
 * @date: 2019/7/22 19:39
 * @description:
 * @since:
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private StoreService storeService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(ProductReq productReq, UserDTO userDTO) {
        // 参数校验
        Assert.notNull(productReq, "商品信息为空");
        Assert.isTrue(StringUtil.isNotBlank(productReq.getName()), "商品名称为空");
        Assert.isTrue(StringUtil.isNotBlank(productReq.getDescription()), "商品描述为空");
        Assert.notNull(productReq.getPrice(), "商品价格为空");
        Assert.notNull(productReq.getQuantity(), "商品数量为空");
        Assert.notNull(productReq.getStoreId(), "店铺编号为空");
        // 逻辑校验
        Assert.isTrue(storeService.isUserOwnStore(productReq.getStoreId(), userDTO.getUserId()), "店铺权限校验失败");
        Assert.isTrue(!this.isStoreHasSameProduct(productReq.getName(), productReq.getStoreId()), "店铺已存在同名商品");
        Product product = ProductConverter.toProduct(productReq);
        productMapper.insertSelective(product);
    }

    private boolean isStoreHasSameProduct(String name, Integer storeId) {
        ProductExample example = new ProductExample();
        example.createCriteria().andStoreIdEqualTo(storeId).andNameEqualTo(name);
        List<Product> products = productMapper.selectByExample(example);
        return !CollectionUtil.isEmpty(products);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decrease(Integer productId, Integer quantity) {
        Product product = productMapper.selectByPrimaryKey(productId);
        product.setQuantity(product.getQuantity() - quantity);
        product.setUpdatedAt(new Date());
        productMapper.updateByPrimaryKey(product);
    }

    @Override
    public boolean isStoreOwnProduct(Integer storeId, Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        return product.getStoreId().equals(storeId);
    }
}
