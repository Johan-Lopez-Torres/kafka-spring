package com.example.springkafka;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventProducer eventProducer;

    public EventController(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    @PostMapping
    public ResponseEntity<String> createEvent(@RequestBody EventRequest eventRequest) {
        eventProducer.produceEvent(eventRequest.getAggregateId(), eventRequest.getEventType(), eventRequest.getPayload());
        return ResponseEntity.ok("Evento publicado");
    }
}
