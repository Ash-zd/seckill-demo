package com.ashzd.seckill.manager.rabbitmq;

import com.ashzd.seckill.common.constant.MqConstant;
import com.ashzd.seckill.dto.UserDTO;
import com.ashzd.seckill.dto.req.PurchaseOrderReq;
import com.ashzd.seckill.dto.req.SeckillReq;
import com.ashzd.seckill.manager.rabbitmq.dto.MqMessage;
import com.ashzd.seckill.service.PurchaseOrderService;
import com.ashzd.seckill.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @file: MessageConsumerImpl
 * @author: Ash
 * @date: 2019/8/16 23:30
 * @description:
 * @since:
 */
@Component
@RabbitListener(queues = MqConstant.TOPIC_ORDER_QUEUE, containerFactory = "customRabbitConsumerFactory")
public class MessageConsumerImpl implements MessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MessageConsumerImpl.class);

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Override
    @RabbitHandler
    public void receiveMessage(MqMessage message) {
        logger.debug("receive message: '{}'", message);
        process(message);
    }

    @Override
    public void process(MqMessage message) {
        Assert.notNull(message, "消息为空");
        Assert.notNull(message.getOperation(), "操作为空");
        Assert.notNull(message.getData(), "消息内容为空");
        String operation = message.getOperation();
        if (!StringUtil.equals("seckill", operation)) {
            return;
        }
        Map<String, Object> data = message.getData();
        SeckillReq req = (SeckillReq) data.get("seckillReq");
        UserDTO userDTO = (UserDTO) data.get("userDTO");
        PurchaseOrderReq purchaseOrderReq = new PurchaseOrderReq();
        purchaseOrderReq.setStoreId(req.getStoreId());
        Map<Integer, Integer> details = new HashMap<>();
        details.put(req.getProductId(), 1);
        purchaseOrderReq.setProducts(details);
        purchaseOrderService.add(purchaseOrderReq, userDTO);
    }
}
