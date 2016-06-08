package org.mgirard.status;

import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by michael.girard on 6/8/16.
 */
@RestController
@RequestMapping("/status")
public class StatusController {
  Status startupStatus;
  public StatusController() {
    startupStatus = new Status();
  }

  @RequestMapping
  @ResponseBody
  public Status getStatus() {
    return startupStatus;
  }


  public class Status {
    private DateTime currentTime = new DateTime();
    private String status = "running";

    @Override
    public String toString() {
      return "Status{" +
          "currentTime=" + currentTime +
          ", status='" + status + '\'' +
          '}';
    }
  }
}
