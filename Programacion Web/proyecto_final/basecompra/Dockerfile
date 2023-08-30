# El builder
# docker build -t znzn00/mock-api .
FROM gradle:7.2.0-jdk11 AS compra_builder
WORKDIR /app
COPY / ./
RUN gradle task bootJar

# Real imagen
FROM openjdk:11.0.7-jre-slim-buster
# Necesario para healthcheck
RUN apt-get update && apt-get install -y curl
# Variables de ambiente declara aqui
ENV APPLICATION_PORT 8080
ENV CONFIGURACION_URL=
ENV EUREKA_URI=
ENV DB_URL=
ENV DB_USER=
ENV DB_PASS=

# Fin de variables de ambiente

WORKDIR /app
#aqui se compia el jar, recomiendo dejarlo como app.jar
COPY --from=compra_builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
