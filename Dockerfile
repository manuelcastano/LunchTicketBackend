FROM openjdk:11

COPY "./target/LunchTicketBackend.jar" "app.jar"

EXPOSE 8081

ENTRYPOINT ["java","-jar","app.jar"]