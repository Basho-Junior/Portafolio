FROM gradle:7.2.0-jdk11 AS user_builder
WORKDIR /app
COPY / ./
RUN gradle task bootJar

FROM openjdk:11.0.7-jre-slim-buster
RUN apt-get update && apt-get install -y curl
ENV APPLICATION_PORT 8080
ENV CONFIGURACION_URL=
ENV EUREKA_URI=
ENV DB_URL=
ENV DB_USER=
ENV DB_PASS=
ENV INIT_INSTANCE=


WORKDIR /app
COPY --from=user_builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
