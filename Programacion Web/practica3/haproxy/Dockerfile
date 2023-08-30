FROM alpine AS certmaker
ENV DOMAIN znzn00.ddns.net
COPY /*.pem /temp/
RUN cat /temp/fullchain.pem /temp/privkey.pem > /temp/$DOMAIN.pem
RUN cat /temp/znzn00.ddns.net.pem

FROM haproxy:2.4.8-alpine
ENV APP_A=127.0.0.1:8080
ENV APP_B=127.0.0.1:8081
ENV APP_C=127.0.0.1:8082
COPY haproxy.cfg /usr/local/etc/haproxy/haproxy.cfg
COPY --from=certmaker /temp/*.pem /usr/local/etc/haproxy/certs/
EXPOSE 80/tcp
EXPOSE 443/tcp
