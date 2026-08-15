package com.learn.rabbitmq.rabbitmq_tutorial.controller;

import com.learn.rabbitmq.rabbitmq_tutorial.dto.User;
import com.learn.rabbitmq.rabbitmq_tutorial.producer.RabbitmqJsonProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JsonMessageController {
    private RabbitmqJsonProducerService rabbitmqJsonProducerService;

    public JsonMessageController(RabbitmqJsonProducerService rabbitmqJsonProducerService) {
        this.rabbitmqJsonProducerService = rabbitmqJsonProducerService;
    }


    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        rabbitmqJsonProducerService.sendJsonMessage(user);
        return ResponseEntity.ok("Message sent");
    }
}
