package com.ashzd.seckill.manager.rabbitmq;

import com.ashzd.seckill.manager.rabbitmq.dto.MqMessage;

/**
 * @file: MessageConsumer
 * @author: Ash
 * @date: 2019/8/16 23:29
 * @description:
 * @since:
 */
public interface MessageConsumer {
    void receiveMessage(MqMessage message);

    void process(MqMessage message);
}
