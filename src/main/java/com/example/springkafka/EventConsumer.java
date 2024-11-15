package com.example.springkafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumer {

    private final EventRepository eventRepository;

    public EventConsumer(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @KafkaListener(topics = "event-topic", groupId = "event-sourcing-group")
    public void consumeEvent(String eventMessage) {
        System.out.println("Consumiendo evento: " + eventMessage);
        eventRepository.save(new Event(eventMessage));
    }
}
