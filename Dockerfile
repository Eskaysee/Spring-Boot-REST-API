FROM openjdk:17

WORKDIR /app

COPY /target/REST-API-0.0.1-SNAPSHOT.jar .

EXPOSE 8082

CMD ["java", "-jar", "REST-API-0.0.1-SNAPSHOT.jar"]
