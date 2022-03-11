package com.learn.rest;

import com.learn.api.EventService;
import com.learn.model.EventDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EventController implements EventApi {

  private final EventService service;
  private final EventAssembler assembler;

  @Override
  public EventModel createEvent(EventDto eventDto) {
    EventDto event = service.createEvent(eventDto);
    return assembler.toModel(event);
  }

  @Override
  public EventModel updateEvent(EventDto eventDto) {
    EventDto event = service.updateEvent(eventDto);
    return assembler.toModel(event);
  }

  @Override
  public EventModel getEvent(long id) {
    EventDto event = service.getEvent(id);
    return assembler.toModel(event);
  }

  @Override
  public ResponseEntity<List<EventDto>> getAllEvents() {
    List<EventDto> allEvents = service.getAllEvents();
    return new ResponseEntity<>(allEvents, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<EventDto>> getAllEventsByTitle(String eventTitle) {
    List<EventDto> allEventsByTitle = service.getAllEventsByTitle(eventTitle);
    return new ResponseEntity<>(allEventsByTitle, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteEvent(long id) {
    service.deleteEvent(id);
    return ResponseEntity.noContent().build();
  }
}
