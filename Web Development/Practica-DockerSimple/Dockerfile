FROM gradle:7.2.0-jdk11 AS builder
WORKDIR /app
COPY / ./
RUN gradle task bootJar

FROM openjdk:11.0.12-jre-slim-buster
ENV APPLICATION_PORT 1234
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
EXPOSE $APPLICATION_PORT:8080
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]



