package com.learn.rabbitmq.rabbitmq_tutorial.controller;

import com.learn.rabbitmq.rabbitmq_tutorial.producer.RabbitmqProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitmqProducerService rabbitmqProducerService;

    public MessageController(RabbitmqProducerService rabbitmqProducerService){
        this.rabbitmqProducerService=rabbitmqProducerService;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        rabbitmqProducerService.sendMessage(message);
        return ResponseEntity.ok("Message Sent");
    }


}
