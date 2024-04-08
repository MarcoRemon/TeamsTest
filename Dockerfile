# Use the official OpenJDK 17 image as base
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper files
COPY gradle/ ./gradle/
COPY gradlew ./

# Copy the Gradle configuration files
COPY build.gradle .
COPY settings.gradle .

# Copy the application source code
COPY src ./src

# Run Gradle to download dependencies and build the application
RUN ./gradlew clean build -x test

# Copy the built JAR file from the Gradle build output directory to /app
COPY build/libs/demo.jar /app/app.jar

# Specify the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
