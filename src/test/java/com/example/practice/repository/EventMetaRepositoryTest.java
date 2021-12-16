package com.example.practice.repository;

import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.practice.domain.EventMeta;
import com.example.practice.event.WeatherEvent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class EventMetaRepositoryTest {

    private final int anInt = 50000;

    @Autowired
    EventRepository eventRepository;

    @BeforeEach
    void beforeEach() {
        eventRepository.deleteAll();
    }

    @Test
    void insertTest() {

        for (int i = 0; i < anInt; i++) {
            EventMeta test = eventRepository.insert(EventMeta.builder()
                .eventData(WeatherEvent.builder().isSunDay(false).build())
                .createTime(Instant.now())
                .eventName("test")
                .build());
            assertNotNull(test.getId());
        }

    }

    @Test
    void insertTest2() {

        List<EventMeta> eventMetas = range(0, anInt).mapToObj(
            i -> EventMeta.builder()
            .eventData(WeatherEvent.builder().isSunDay(false).build())
            .createTime(Instant.now())
            .eventName("test")
            .build()).collect(Collectors.toList());
        List<EventMeta> insertedMetas = eventRepository.insert(eventMetas);
        insertedMetas.forEach(eventMeta -> assertNotNull(eventMeta.getId()));

    }
}