# spring-boot-with-jms
spring boot example for using jms (activemq)

## run a activemq broker
I recommend using docker for this purpose, e.g.:
```
docker pull rmohr/activemq
docker run -p 61616:61616 -p 8161:8161 rmohr/activemq
```
The web-console can be accessed at http://localhost:8161 (admin/admin)


## build 
```
mvn clean package
```

## run
```
java -jar target/spring-boot-with-jms-1.0-SNAPSHOT.jar
```

## Options

You may provide a profile as system parameter to run as sender or receiver
(The default config uses sender and receiver at the same time).
```
java -jar -Dspring.profiles.active=sender target/spring-boot-with-jms-1.0-SNAPSHOT.jar
```

You can configure the send.rate for a sender and the processing.time of a receiver
by appending "--send.rate=<value in ms>" and "--processing.time=<value in ms>"
at the end of the command.


