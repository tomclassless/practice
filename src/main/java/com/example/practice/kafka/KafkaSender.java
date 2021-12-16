package com.example.practice.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class KafkaSender {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson gson = new GsonBuilder().create();

    public KafkaSender(
        KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //傳送訊息方法
    public void send(String topic, Message message) {
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic,
            gson.toJson(message));
        send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }
            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("msg sent!");
            }
        });
    }
}