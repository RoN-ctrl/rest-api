package com.learn.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EventDto {

  private long id;
  private String title;
  private int place;
  private String speaker;
  private String eventType;
  private LocalDateTime dateTime;
}
