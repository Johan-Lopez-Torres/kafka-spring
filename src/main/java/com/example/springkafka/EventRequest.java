package com.example.springkafka;

import lombok.Data;

@Data
public class EventRequest {

    private String aggregateId;
    private String eventType;
    private String payload;

    // Getters and setters
}
