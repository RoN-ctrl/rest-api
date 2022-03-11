package com.learn.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class Event {

  private static long countId = 0;

  private long id;
  private String title;
  private int place;
  private String speaker;
  private String eventType;
  private LocalDateTime dateTime;

  public Event(String title, int place, String speaker, String eventType, LocalDateTime dateTime) {
    this.id = ++countId;
    this.title = title;
    this.place = place;
    this.speaker = speaker;
    this.eventType = eventType;
    this.dateTime = dateTime;
  }
}
