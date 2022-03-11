package com.learn.rest;

import com.learn.model.EventDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class EventAssembler extends RepresentationModelAssemblerSupport<EventDto, EventModel> {

  public EventAssembler() {
    super(EventController.class, EventModel.class);
  }

  @Override
  public EventModel toModel(EventDto entity) {
    EventModel eventModel = new EventModel(entity);

    Link createEvent = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
            .methodOn(EventController.class)
            .createEvent(entity))
        .withRel("createEvent");

    Link eventById = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
            .methodOn(EventController.class)
            .getEvent(entity.getId()))
        .withRel("getEventById");

    Link allEvents = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
            .methodOn(EventController.class)
            .getAllEvents())
        .withRel("getAllEvent");

    Link update = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
            .methodOn(EventController.class)
            .updateEvent(entity))
        .withRel("updateEvent");

    Link deleteEvent = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
            .methodOn(EventController.class)
            .deleteEvent(entity.getId()))
        .withRel("deleteEvent");

    eventModel.add(createEvent, eventById, allEvents, update, deleteEvent);
    return eventModel;
  }
}
