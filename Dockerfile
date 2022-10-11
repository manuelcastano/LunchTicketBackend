FROM openjdk:11
<<<<<<< HEAD

COPY "./target/LunchTicketBackend.jar" "app.jar"

EXPOSE 8081
=======
ENV TZ=GMT

WORKDIR /app

ARG JAR_FILE=target/LunchTicketBackend.jar

# cp spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar
>>>>>>> 96dd06878d34a7cd2d03939043fb31638e9e82d6

ENTRYPOINT ["java","-jar","app.jar"]