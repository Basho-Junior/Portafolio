# El builder
# docker build -t znzn00/mock-api .
FROM gradle:7.2.0-jdk11 AS builder
WORKDIR /app
COPY / ./
RUN gradle task bootJar

# Real imagen
FROM openjdk:11.0.7-jre-slim-buster
# Configuración de la aplicación
ENV APPLICATION_PORT 8080
ENV APP_DB_URL=
ENV APP_DB_DRIVER_CLASSNAME=
ENV APP_DB_PLATFORM=
ENV APP_DB_USERNAME=
ENV APP_DB_PASSWORD=
WORKDIR /app
EXPOSE ${APPLICATION_PORT}/tcp
COPY --from=builder /app/build/libs/*.jar app.jar
# este entrypoint no funciona debido a que no le gusta resolver los enviroment variables
# ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=$APPLICATION_PORT"]
# el exec es importante, ya que esto es ejecutado como un /bin/bash, exec hara que
# el proceso child asuma el control que tiene su pariente
# ENTRYPOINT exec java -jar app.jar --server.port=$APPLICATION_PORT
COPY running_script.sh run.sh
ENTRYPOINT ["sh","./run.sh"]