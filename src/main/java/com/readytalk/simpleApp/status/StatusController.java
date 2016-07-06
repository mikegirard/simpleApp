package com.readytalk.simpleApp.status;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/status")
public class StatusController {

  Status startupStatus;

  public StatusController() {
    startupStatus = new Status();
  }

  // @CrossOrigin
  @RequestMapping
  public Status getStatus() {
    return startupStatus;
  }


  public class Status {

    private DateTime startTime = new DateTime();
    private DateTime currentTime = new DateTime();
    private String status = "healthy";

    @Override
    public String toString() {
      return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public String getStartTime() {
      return startTime.toString();
    }

    public String getCurrentTime( ) {
      return currentTime.toString();
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }
  }
}
