package com.learn.rabbitmq.rabbitmq_tutorial.producer;

import com.learn.rabbitmq.rabbitmq_tutorial.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqJsonProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitmqJsonProducerService.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String key;

    private RabbitTemplate rabbitTemplate;

    public RabbitmqJsonProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user) {
        rabbitTemplate.convertAndSend(exchange,key,user);
        LOGGER.info("Json message Sent -> {}",user);
    }
}
