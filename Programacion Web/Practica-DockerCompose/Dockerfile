FROM gradle:7.2.0-jdk11 AS builder
WORKDIR /app
COPY / ./
RUN gradle task bootJar

FROM openjdk:11.0.7-jre-slim-buster

ENV APPLICATION_PORT 8080
ENV APP_DB_URL=
ENV APP_DB_DRIVER_CLASSNAME=
ENV APP_DB_PLATFORM=
ENV APP_DB_USERNAME=
ENV APP_DB_PASSWORD=
WORKDIR /app
EXPOSE ${APPLICATION_PORT}/tcp
COPY --from=builder /app/build/libs/*.jar app.jar

COPY running_script.sh run.sh
ENTRYPOINT ["sh","./run.sh"]


