package com.example.springkafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "event-topic";


    public EventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceEvent(String aggregateId, String eventType, String payload) {
        String eventMessage = String.format("{\"aggregateId\":\"%s\", \"eventType\":\"%s\", \"payload\":\"%s\"}", aggregateId, eventType, payload);
        kafkaTemplate.send(TOPIC, aggregateId, eventMessage);
    }
}
