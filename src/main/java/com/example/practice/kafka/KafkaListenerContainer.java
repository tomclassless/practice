package com.example.practice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by TomTang on 2021/12/16
 */
@Component
public class KafkaListenerContainer {

    @KafkaListener(id = "webGroup", topics = {"test"})
    public void listen(String input) {
        System.out.printf("new message: %s%n", input);
    }
}
