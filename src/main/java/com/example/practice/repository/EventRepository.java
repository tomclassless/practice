package com.example.practice.repository;

import com.example.practice.domain.EventMeta;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<EventMeta, String> {

    @Query("{'eventData._class': ?0}")
    List<EventMeta> findAll(String eventClassName);
}
