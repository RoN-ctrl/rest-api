package com.learn.rest;

import com.learn.model.EventDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(tags = "Events API")
@RequestMapping("/events-api/v1/event")
public interface EventApi {

  @ApiOperation("Create event")
  @ApiResponses({
      @ApiResponse(code = 201, message = "Event created"),
      @ApiResponse(code = 403, message = "Forbidden"),
      @ApiResponse(code = 500, message = "Internal server error")
  })
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  EventModel createEvent(@RequestBody EventDto eventDto);

  @ApiOperation("Update event")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Event updated"),
      @ApiResponse(code = 404, message = "Event not found"),
      @ApiResponse(code = 500, message = "Internal server error")
  })
  @ResponseStatus(HttpStatus.OK)
  @PutMapping
  EventModel updateEvent(@RequestBody EventDto eventDto);

  @ApiOperation("Get event by id")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Event found"),
      @ApiResponse(code = 404, message = "Event not found"),
      @ApiResponse(code = 500, message = "Internal server error")
  })
  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/{id}")
  EventModel getEvent(@PathVariable long id);

  @ApiOperation("Get all events")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Events found"),
      @ApiResponse(code = 404, message = "Events not found"),
      @ApiResponse(code = 500, message = "Internal server error")
  })
  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/all")
  ResponseEntity<List<EventDto>> getAllEvents();

  @ApiOperation("Get event by title")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Event found"),
      @ApiResponse(code = 404, message = "Event not found"),
      @ApiResponse(code = 500, message = "Internal server error")
  })
  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/title/{title}")
  ResponseEntity<List<EventDto>> getAllEventsByTitle(@PathVariable(name = "title") String eventTitle);

  @ApiOperation("Delete event")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Event found"),
      @ApiResponse(code = 404, message = "Event not found"),
      @ApiResponse(code = 500, message = "Internal server error")
  })
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteEvent(@PathVariable long id);

}
