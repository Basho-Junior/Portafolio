FROM gradle:7.2.0-jdk11 AS builder
WORKDIR /app
COPY / ./
RUN gradle task bootJar


FROM openjdk:11.0.7-jre-slim-buster
ENV APPLICATION_PORT 8081
ENV BROKER_CONNECTION localhost:61616
WORKDIR /app
EXPOSE ${APPLICATION_PORT}/tcp
COPY --from=builder /app/build/libs/*.jar app.jar
COPY running_script.sh run.sh
ENTRYPOINT ["sh","./run.sh"]