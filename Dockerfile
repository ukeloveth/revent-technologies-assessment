# 1. Use official Maven image to build the application
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies (to leverage Docker layer caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the application (skip tests for faster build in production)
RUN mvn clean package -DskipTests

# 2. Use a lightweight JDK base image for running the app
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose application port (adjust to match your app's port)
EXPOSE 8080

# Default command
ENTRYPOINT ["java", "-jar", "app.jar"]