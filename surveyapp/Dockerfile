FROM openjdk:17-jdk-slim

WORKDIR /survey-app

COPY target/survey-app.jar app.jar

# Expose the port that your Spring Boot app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]
