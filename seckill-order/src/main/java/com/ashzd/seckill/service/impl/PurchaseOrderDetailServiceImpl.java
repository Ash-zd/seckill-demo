package com.ashzd.seckill.service.impl;

import com.ashzd.seckill.dto.PurchaseOrderDetailDTO;
import com.ashzd.seckill.entity.Product;
import com.ashzd.seckill.entity.PurchaseOrderDetail;
import com.ashzd.seckill.mapper.ProductMapper;
import com.ashzd.seckill.mapper.PurchaseOrderDetailMapper;
import com.ashzd.seckill.service.ProductService;
import com.ashzd.seckill.service.PurchaseOrderDetailService;
import com.ashzd.seckill.util.converter.PurchaseOrderDetailConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

/**
 * @file: OrderDetailServiceImpl
 * @author: Ash
 * @date: 2019/7/23 15:37
 * @description:
 * @since:
 **/
@Service
public class PurchaseOrderDetailServiceImpl implements PurchaseOrderDetailService {

    @Autowired
    private PurchaseOrderDetailMapper purchaseOrderDetailMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductService productService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BigDecimal addAndReturnTotalPrice(PurchaseOrderDetailDTO orderDetailDTO) {
        Product product = productMapper.selectByPrimaryKey(orderDetailDTO.getProductId());
        orderDetailDTO.setProductName(product.getName());
        orderDetailDTO.setProductDescription(product.getDescription());
        orderDetailDTO.setProductUnitPrice(product.getPrice());
        Assert.isTrue(product.getQuantity() >= orderDetailDTO.getProductQuantity(), "商品库存不足");
        PurchaseOrderDetail orderDetail = PurchaseOrderDetailConverter.toPurchaseOrderDetail(orderDetailDTO);
        purchaseOrderDetailMapper.insertSelective(orderDetail);
        productService.decrease(orderDetail.getProductId(), orderDetail.getProductQuantity());
        return orderDetail.getProductUnitPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()));

    }

    @Override
    public List<PurchaseOrderDetailDTO> query(String orderIndexCode) {
        return null;
    }
}
