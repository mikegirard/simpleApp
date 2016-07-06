package com.readytalk.simpleApp.schedule;


import com.opencsv.CSVReader;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component("scheduleLoader")
public class ScheduleCSVLoader implements ScheduleLoader {

  Logger logger = LoggerFactory.getLogger(ScheduleCSVLoader.class);

  @Value("classpath:schedule.csv")
  Resource scheduleCsv;


  @PostConstruct
  public void init() {
    logger.warn("Loading Jar'd CSV file: {}", scheduleCsv.getFilename());
  }

  @Override
  public List<Game> loadGames() throws IOException {
    List<Game> games = new ArrayList<>();
    CSVReader reader = new CSVReader(new InputStreamReader(scheduleCsv.getInputStream()));
    int index = 0;
    for (String[] row : reader.readAll()) {
      index++;
      if (index == 1) {
        continue;
      }

      try {
        Game game = (new Game(LocalDate.parse(row[0], DateTimeFormat.forPattern("MM/dd/yy")),
            LocalTime.parse(row[1], DateTimeFormat.forPattern("kk:mm a")),
            row[3],
            row[4],
            LocalTime.parse(row[9], DateTimeFormat.forPattern("kk:mm a"))
        ));
        logger.debug("Game: {}", game);
        games.add(game);
      } catch (IllegalArgumentException e) {
        logger.error("Unable to parse row {}", e);
      }

    }
    Collections.sort(games);
    return games;
  }


}
