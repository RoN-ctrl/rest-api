package com.learn.service;

import com.learn.api.EventService;
import com.learn.model.Event;
import com.learn.model.EventDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

  private final List<Event> events = new ArrayList<>();

  @Override
  public EventDto createEvent(EventDto eventDto) {
    log.info("create event {}", eventDto);
    Event event = mapEventDtoToEvent(eventDto);
    events.add(event);
    return mapEventToEventDto(event);
  }

  @Override
  public EventDto updateEvent(EventDto eventDto) {
    log.info("update event {}", eventDto);
    Event eventToUpdate = events.stream().filter(e -> e.getId() == eventDto.getId()).findFirst().orElseThrow();
    eventToUpdate.setTitle(eventDto.getTitle());
    eventToUpdate.setPlace(eventDto.getPlace());
    eventToUpdate.setSpeaker(eventDto.getSpeaker());
    eventToUpdate.setEventType(eventDto.getEventType());
    eventToUpdate.setDateTime(eventDto.getDateTime());
    return mapEventToEventDto(eventToUpdate);
  }

  @Override
  public EventDto getEvent(long id) {
    log.info("get event by id={}", id);
    Event event = events.stream()
        .filter(e -> e.getId() == id)
        .findFirst().orElseThrow();
    return mapEventToEventDto(event);
  }

  @Override
  public List<EventDto> getAllEvents() {
    log.info("create all events");
    return events.stream()
        .map(this::mapEventToEventDto)
        .collect(Collectors.toUnmodifiableList());
  }

  @Override
  public List<EventDto> getAllEventsByTitle(String eventTitle) {
    log.info("create all events by title={}", eventTitle);
    return events.stream()
        .filter(e -> e.getTitle().equals(eventTitle))
        .map(this::mapEventToEventDto)
        .collect(Collectors.toUnmodifiableList());
  }

  @Override
  public void deleteEvent(long id) {
    log.info("delete event by id={}", id);
    Event event = events.stream()
        .filter(e -> e.getId() == id)
        .findFirst().orElseThrow();
    events.remove(event);
  }

  private Event mapEventDtoToEvent(EventDto eventDto) {
    return new Event(eventDto.getTitle(), eventDto.getPlace(), eventDto.getSpeaker(), eventDto.getEventType(),
        eventDto.getDateTime());
  }

  private EventDto mapEventToEventDto(Event event) {
    return EventDto.builder()
        .id(event.getId())
        .title(event.getTitle())
        .place(event.getPlace())
        .speaker(event.getSpeaker())
        .eventType(event.getEventType())
        .dateTime(event.getDateTime())
        .build();
  }
}
