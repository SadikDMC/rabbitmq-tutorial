package com.learn.rabbitmq.rabbitmq_tutorial.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqConsumerService {
    private final static Logger LOGGER= LoggerFactory.getLogger(RabbitmqConsumerService.class);

    @RabbitListener(queues={"${rabbitmq.queue.name}"})
    public void consume(String message) {
        LOGGER.info("Message Recieved -> {}", message);
    }
}
