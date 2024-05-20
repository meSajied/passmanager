# Use official OpenJDK image as a base image
FROM maven:3.8.5-openjdk-17 as build
copy . .

run mvn clean package

FROM openjdk:17.0.1-jdk-slim

copy --from=build /target/passmanager.jar passmanager.jar

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY /target/passmanager.jar /app/passmanager.jar

# Expose the port the application runs on
EXPOSE 7777

# Specify the command to run on container start, passing environment variables
# Specify the command to run on container start, passing environment variables
ENTRYPOINT ["java", "-jar", "-Dspring.data.mongodb.uri=${DATABASE_URL}", "your-application.jar", "--spring.config.location=classpath:/application.yml"]

