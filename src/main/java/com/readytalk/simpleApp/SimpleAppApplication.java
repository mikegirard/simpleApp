package com.readytalk.simpleApp;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.joda.cfg.JacksonJodaDateFormat;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateSerializer;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.joda.DateTimeFormatterFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
public class SimpleAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(SimpleAppApplication.class, args);
  }


  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurerAdapter() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
            //.allowedOrigins("http://192.168.200.40:3000").allowedOrigins("http://localhost:3000").allowedOrigins("http://localhost");
      }
    };
  }

  /*
  @Bean
  public Jackson2ObjectMapperBuilder jacksonBuilder() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.featuresToEnable(SerializationFeature.WRAP_ROOT_VALUE); // enables wrapping for root elements
    return builder;
  }
  */
  /*
  @Bean
  public JodaModule jacksonJodaModule() {
    JodaModule module = new JodaModule();
    DateTimeFormatterFactory formatterFactory = new DateTimeFormatterFactory();

    formatterFactory.setIso(DateTimeFormat.ISO.DATE_TIME);
    module.addSerializer(DateTime.class, new DateTimeSerializer(
        new JacksonJodaDateFormat(formatterFactory.createDateTimeFormatter()
            .withZoneUTC())));
    return module;
  }
  */
}
