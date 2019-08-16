package com.ashzd.seckill.common.constant;

/**
 * @file: MqConstant
 * @author: Ash
 * @date: 2019/8/16 15:39
 * @description:
 * @since:
 */
public class MqConstant {

    public static final String TOPIC_EXCHANGE = "topic.exchange";
    public static final String TOPIC_ORDER_QUEUE = "topic.order";

    // routingKey
    public static final String ROUTING_KEY_TOPIC_ORDER_QUEUE = "topic.order.#";

}
