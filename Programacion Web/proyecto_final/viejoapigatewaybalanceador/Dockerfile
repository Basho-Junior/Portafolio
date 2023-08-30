# El builder
# docker build -t znzn00/mock-api .
FROM gradle:7.2.0-jdk11 AS gateway_balancer_builder
WORKDIR /app
COPY / ./
RUN gradle task bootJar

# Real imagen
FROM openjdk:11.0.7-jre-slim-buster
RUN apt-get update && apt-get install -y curl
# Variables de ambiente declara aqui
ENV APPLICATION_PORT 8080
# Fin de variables de ambiente

EXPOSE ${APPLICATION_PORT}/tcp

WORKDIR /app
#aqui se compia el jar, recomiendo dejarlo como app.jar
COPY --from=gateway_balancer_builder /app/build/libs/*.jar gateway_balancer.jar
ENTRYPOINT ["java","-jar","/app/gateway_balancer.jar", "--spring.profiles.active=docker"]
