# Stage 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Set working directory inside the container
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create a lean runtime image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the JAR from the builder image
COPY --from=builder /app/target/*.jar app.jar

# Expose the port if applicable (optional — only needed if the app has a web server)
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
