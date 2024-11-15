package com.example.springkafka;

import java.util.ArrayList;
import java.util.List;

public class Aggregate {

    private String aggregateId;
    private List<Event> events;

    public Aggregate(String aggregateId) {
        this.aggregateId = aggregateId;
        this.events = new ArrayList<>();
    }

    public void applyEvent(Event event) {
        // Actualiza el estado basado en el evento.
        events.add(event);
    }

    // Métodos de estado...
}
