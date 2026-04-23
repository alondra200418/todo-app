# Use a base image with JDK 17
FROM eclipse-temurin:17-jdk

# The Spring Boot plugin names the file 'todo-app-1.0-SNAPSHOT.jar'
COPY target/todo-app-1.0-SNAPSHOT.jar app.jar

# Set the entry point to run the JAR
ENTRYPOINT ["java", "-jar", "/app.jar"]