FROM openjdk:13-alpine

COPY target/frontdoor.jar

CMD ["java" "jar" "frontdoor.jar"]
