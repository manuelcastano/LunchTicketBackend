FROM openjdk:11

COPY "./target/LunchTicketBackend.jar" "app.jar"

EXPOSE 8081
ENV TZ=GMT

WORKDIR /app
VOLUME /tmp

ARG JAR_FILE=target/LunchTicketBackend.jar

# cp spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]