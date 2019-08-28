package com.ashzd.seckill.service.impl;

import com.ashzd.seckill.common.constant.RedisConstant;
import com.ashzd.seckill.dto.PurchaseOrderDTO;
import com.ashzd.seckill.dto.PurchaseOrderDetailDTO;
import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.req.PurchaseOrderReq;
import com.ashzd.seckill.dto.req.SeckillReq;
import com.ashzd.seckill.dto.req.page.OrderPageReq;
import com.ashzd.seckill.entity.PurchaseOrder;
import com.ashzd.seckill.manager.rabbitmq.MessageProducer;
import com.ashzd.seckill.manager.rabbitmq.dto.MqMessage;
import com.ashzd.seckill.manager.redis.RedisManager;
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
import java.util.*;

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
    @Autowired
    private RedisManager redisManager;
    @Autowired
    private MessageProducer messageProducer;

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

    @Override
    public void seckill(SeckillReq seckillReq, UserDTO userDTO) {
        Assert.notNull(seckillReq, "订单信息为空");
        Assert.notNull(seckillReq.getStoreId(), "店铺编号为空");
        Assert.notNull(seckillReq.getProductId(), "商品为空");
        // redis 预减库存
        Integer productId = seckillReq.getProductId();
        boolean result = redisManager.decrease(RedisConstant.PRODUCT_QUANTITY_PREFIX, Integer.toString(productId));
        Assert.isTrue(result, "库存不足");
        // 转发流量到消息队列
        MqMessage message = new MqMessage();
        message.setOperation("seckill");
        Map<String, Object> data = new HashMap<>();
        data.put("seckillReq", seckillReq);
        data.put("userDTO", userDTO);
        message.setData(data);
        messageProducer.sendMessage(message);
    }
}
