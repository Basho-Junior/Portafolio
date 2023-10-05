# El builder
# docker build -t znzn00/mock-api .
FROM gradle:7.2.0-jdk11 AS gateway_builder
WORKDIR /app
COPY / ./
RUN gradle task bootJar

# Real imagen
FROM openjdk:11.0.7-jre-slim-buster
# Necesario para healthcheck
RUN apt-get update && apt-get install -y curl
ENV APPLICATION_PORT 8080
ENV CONFIGURACION_URL=
ENV EUREKA_URI=
WORKDIR /app
COPY --from=gateway_builder /app/build/libs/*.jar gateway.jar
ENTRYPOINT ["java","-jar","/app/gateway.jar"]
