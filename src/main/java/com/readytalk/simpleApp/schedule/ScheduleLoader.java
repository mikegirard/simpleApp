package com.readytalk.simpleApp.schedule;

import java.io.IOException;
import java.util.List;

public interface ScheduleLoader {

  List<Game> loadGames() throws IOException;
}
