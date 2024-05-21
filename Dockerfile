FROM maven:3.8.5-openjdk-17 AS build
copy . .

RUN mvn package -X

FROM openjdk:17.0.1-jdk-slim

COPY --from=build /target/passmanager.jar /app/passmanager.jar

# Set the working directory in the container
WORKDIR /app

# Expose the port the application runs on
EXPOSE 7777

ENTRYPOINT ["java", "-jar", "-Dspring.data.mongodb.uri=${DATABASE_URL}", "/app/passmanager.jar", "--spring.config.location=classpath:/application.yml"]

