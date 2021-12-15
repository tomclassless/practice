package com.example.practice.repository;

import com.example.practice.domain.Event;
import com.example.practice.event.Weather;
import java.time.Instant;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventRepositoryTest {

    @Autowired
    EventRepository eventRepository;

    @Test
    void insertTest() {

        Event event = new Event<>();
        event.setEventName(null);
        event.setEventData(new Weather());
        event.setCreateTime(Instant.now());
        event.setEventType("weather");

        eventRepository.insert(event);

    }

    @Test
    void findTest() {

        List<Event> events = eventRepository.findAll();
        events.forEach(event -> {
            if (event.getEventData() instanceof Weather) {
                System.out.println(event);
            }
        });
    }

}