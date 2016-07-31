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

