package com.learn.api;

import com.learn.model.EventDto;
import java.util.List;

public interface EventService {

  EventDto createEvent(EventDto eventDto);

  EventDto updateEvent(EventDto eventDto);

  EventDto getEvent(long id);

  List<EventDto> getAllEvents();

  List<EventDto> getAllEventsByTitle(String eventTitle);

  void deleteEvent(long id);

}
