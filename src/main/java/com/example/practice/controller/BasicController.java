package com.example.practice.controller;

import com.example.practice.kafka.KafkaSender;
import com.example.practice.kafka.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    private final KafkaSender kafkaSender;

    @Autowired
    public BasicController(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @GetMapping("/")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello world");
    }

    @GetMapping("/kafka")
    public ResponseEntity<String> sendMsg() {

        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());

        kafkaSender.send("test", message);

        return ResponseEntity.ok("ok");
    }
}
