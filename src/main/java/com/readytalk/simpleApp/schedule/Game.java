package com.readytalk.simpleApp.schedule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

@JsonRootName("Game")
public class Game implements Comparable<Game> {
  private LocalDate day;
  private LocalTime startTime;
  private String title;
  private String description;
  private LocalTime endTime;


  public Game(LocalDate day, LocalTime startTime, String title, String description, LocalTime endTime) {
    this.day = day;
    this.startTime = startTime;
    this.title = title;
    this.description = description;
    this.endTime = endTime;
  }

  @Override
  public int compareTo(Game o) {
    return this.getStartDateTime().compareTo(o.getStartDateTime());
  }

  @JsonIgnore
  public LocalDate getDay() {
    return day;
  }

  @JsonIgnore
  public LocalTime getStartTime() {
    return startTime;
  }

  public String getTitle() {
    return title;
  }

  public String getLocation() {
    return description;
  }

  @JsonIgnore
  public LocalTime getEndTime() {
    return endTime;
  }

  public DateTime getStartDateTime() {
    return getDay().toDateTime(getStartTime());
  }

  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);
  }
}
