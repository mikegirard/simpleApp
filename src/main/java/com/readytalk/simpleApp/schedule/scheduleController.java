package com.readytalk.simpleApp.schedule;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
public class ScheduleController {

  Logger logger = LoggerFactory.getLogger(ScheduleController.class);

  @Autowired
  ScheduleService scheduleService;

  @RequestMapping(method = {RequestMethod.GET})
  public List<Game> listGames() {
    return scheduleService.getGames();
  }

  @RequestMapping(value = "/next", method = {RequestMethod.GET})
  public List<Game> nextGame(@RequestParam(required = false, defaultValue = "1") int num) {
    DateTime today = new LocalDate().toDateTimeAtStartOfDay();
    return scheduleService.getNextGames(today, num);
  }

  @RequestMapping(value = "/today", method = {RequestMethod.GET})
  public Game gameToday() {
    List<Game> next = nextGame(1);
    if (next.isEmpty() || next.get(0).getStartDateTime().toLocalDate().isAfter(new LocalDate())) {
      throw new NoGameException();
    }
    return next.get(0);
  }


}
