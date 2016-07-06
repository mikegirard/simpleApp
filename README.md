Simple application to pull information about the Rockies home schedule
======================================================================

This is a simple spring boot application that will load a list of games 
from a CSV that is bundled in  src/main/resources/schedule.csv

Building
--------
```
mvn package
```

Running
-------
```
java -jar target/simpleApp-<version>.jar
```

To change property values, you can set them as environment variables or
pass them as part of the command line. For example, to change the port tomcat
is listening on:

```
java -jar target/simpleApp-<version>.jar --server.port=8090
``` 

API Documentation
-----------------
The src/main/resource/public/api-docs folder contains the swagger defintion files.
While the app is running, you can examine them at http://localhost:8080/docs/index.html

Configuration
-------------
This is really a simple, self-contained service. Here are some useful links
for more info on spring boot:

If you want to customize the Jackson json configuration: 
http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#howto-customize-the-jackson-objectmapper

Some commonly used spring boot properties (you can modify src/main/resources/application.properties)
http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
