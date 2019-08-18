package com.ashzd.seckill.manager.rabbitmq;

import com.ashzd.seckill.common.constant.MqConstant;
import com.ashzd.seckill.manager.rabbitmq.dto.MqMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @file: MessageProducerImpl
 * @author: Ash
 * @date: 2019/8/16 23:29
 * @description:
 * @since:
 */
@Service
public class MessageProducerImpl implements MessageProducer {

    private static final Logger logger = LoggerFactory.getLogger(MessageProducerImpl.class);

    @Autowired
    private AmqpTemplate rabbitMqTemplate;

    @Override
    public void sendMessage(String exchange, String routingKey, MqMessage message) {
        logger.debug("send message '{}'", message);
        rabbitMqTemplate.convertAndSend(exchange, routingKey, message);
    }

    @Override
    public void sendMessage(MqMessage message) {
        logger.debug("send message '{}'", message);
        try {
            rabbitMqTemplate.convertAndSend(MqConstant.TOPIC_EXCHANGE, MqConstant.TOPIC_ORDER_QUEUE, message);
        } catch (AmqpException e) {
            e.printStackTrace();
        }
    }
}
