package com.learn.rabbitmq.rabbitmq_tutorial.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitmqProducerService {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

     private static final Logger LOGGER = LoggerFactory.getLogger(RabbitmqProducerService.class);
//spring automatically inject the rabbit template bean
    public RabbitmqProducerService(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info("Message sent -> {}",message);
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }
}
