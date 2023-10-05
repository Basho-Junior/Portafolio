FROM gradle:7.2.0-jdk11 AS gateway_builder
WORKDIR /app
COPY / ./
RUN gradle task bootJar

FROM openjdk:11.0.7-jre-slim-buster
RUN apt-get update && apt-get install -y curl
ENV APPLICATION_PORT 8080
ENV CONFIGURACION_URL=
ENV EUREKA_URI=
WORKDIR /app
COPY --from=gateway_builder /app/build/libs/*.jar Gateway.jar
ENTRYPOINT ["java","-jar","/app/Gateway.jar"]
