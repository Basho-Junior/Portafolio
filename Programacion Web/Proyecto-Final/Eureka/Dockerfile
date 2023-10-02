FROM gradle:7.2.0-jdk11 AS eureka_builder
WORKDIR /app
COPY / ./
RUN gradle task bootJar

FROM openjdk:11.0.7-jre-slim-buster
RUN apt-get update && apt-get install -y curl
ENV APPLICATION_PORT 8080
ENV CONFIGURACION_URL=


WORKDIR /app
COPY --from=eureka_builder /app/build/libs/*.jar eureka_server.jar
ENTRYPOINT ["java","-jar","/app/eureka_server.jar", "--spring.profiles.active=docker"]
