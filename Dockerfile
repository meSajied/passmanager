# Use official OpenJDK image as a base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY target/passmanager.jar /app/passmanager.jar

# Expose the port the application runs on
EXPOSE 8080

# Specify the command to run on container start, passing environment variables
# Specify the command to run on container start, passing environment variables
CMD ["java", "-jar", "-Dspring.data.mongodb.uri=${DATABASE_URL}", "your-application.jar", "--spring.config.location=classpath:/application.yml"]

