package com.readytalk.simpleApp.schedule;


import org.joda.time.ReadableInstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
  private Logger logger = LoggerFactory.getLogger(ScheduleService.class);

  @Autowired
  @Qualifier("scheduleLoader")
  ScheduleCSVLoader gameLoader;

  private List<Game> cachedGames = null;


  @PostConstruct
  public synchronized void initGames() {
    if (cachedGames == null) {
      try {
        cachedGames = gameLoader.loadGames();
      } catch (IOException e) {
        logger.error("Unable to load games due to exception", e);
        cachedGames = new ArrayList<Game>();
      }
    }
  }


  public List<Game> getNextGames(ReadableInstant afterInstant, int numResults) {
    boolean matched = false;
    int index = 0;
    for (Game game : getGames()) {
      if (afterInstant.isBefore(game.getStartDateTime())) {
        matched = true;
        break;
      }
      index++;
    }
    if (matched) {
      List<Game> list =  getGames().subList(index, index + numResults);
      return list;
    } else {
      return new ArrayList<Game>();
    }
  }

  public List<Game> getGames() {
    return cachedGames;
  }


}
