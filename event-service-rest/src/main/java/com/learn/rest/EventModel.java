package com.learn.rest;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.learn.model.EventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class EventModel extends RepresentationModel<EventModel> {

  @JsonUnwrapped
  private EventDto eventDto;
}
