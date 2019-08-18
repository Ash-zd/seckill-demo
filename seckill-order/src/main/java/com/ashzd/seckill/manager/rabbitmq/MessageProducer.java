package com.ashzd.seckill.manager.rabbitmq;

import com.ashzd.seckill.manager.rabbitmq.dto.MqMessage;

/**
 * @file: MessageProducer
 * @author: Ash
 * @date: 2019/8/16 23:29
 * @description:
 * @since:
 */
public interface MessageProducer {
    void sendMessage(String exchange, String routingKey, MqMessage message);

    void sendMessage(MqMessage message);
}
