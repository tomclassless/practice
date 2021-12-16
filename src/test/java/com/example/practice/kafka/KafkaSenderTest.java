package com.example.practice.kafka;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaSenderTest {

    @Autowired
    KafkaSender kafkaSender;

    @Test
    void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());

        kafkaSender.send("test", message);
    }
}