# El builder
# docker build -t znzn00/mock-api .
FROM gradle:7.2.0-jdk11 AS builder
WORKDIR /app
COPY / ./
RUN gradle task bootJar

# Real imagen
FROM openjdk:11.0.7-jre-slim-buster
# Configuración de la aplicación
ENV APPLICATION_PORT 8082
ENV BROKER_PORT 61616
WORKDIR /app
EXPOSE ${APPLICATION_PORT}/tcp
EXPOSE ${BROKER_PORT}/tcp
COPY --from=builder /app/build/libs/*.jar app.jar
COPY running_script.sh run.sh
ENTRYPOINT ["sh","./run.sh"]