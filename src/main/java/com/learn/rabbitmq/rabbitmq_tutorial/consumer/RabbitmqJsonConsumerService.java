package com.learn.rabbitmq.rabbitmq_tutorial.consumer;

import com.learn.rabbitmq.rabbitmq_tutorial.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqJsonConsumerService {

    Logger LOGGER = LoggerFactory.getLogger(RabbitmqJsonConsumerService.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public  void consume(User user){
        LOGGER.info("Message recieved -> {}",user);
    }
}
