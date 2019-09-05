package com.ashzd.seckill.config.rabbitmq;

import com.ashzd.seckill.common.constant.MqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @file: RabbitMqConfig
 * @author: Ash
 * @date: 2019/8/16 15:36
 * @description:
 * @since:
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue topicOrderQueue() {
        return new Queue(MqConstant.TOPIC_ORDER_QUEUE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(MqConstant.TOPIC_EXCHANGE);
    }

    @Bean
    public Binding topicBind() {
        return BindingBuilder.bind(topicOrderQueue()).to(topicExchange()).with(MqConstant.TOPIC_ORDER_QUEUE);
    }

    @Bean("customRabbitConsumerFactory")
    public SimpleRabbitListenerContainerFactory containerFactory(SimpleRabbitListenerContainerFactoryConfigurer containerFactoryConfigurer, ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConcurrentConsumers(10);
        factory.setMaxConcurrentConsumers(20);
        containerFactoryConfigurer.configure(factory, connectionFactory);
        return factory;
    }

}
