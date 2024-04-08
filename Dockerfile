FROM openjdk:17

WORKDIR /app

COPY gradle/ ./gradle/
COPY gradlew ./

COPY build.gradle .
COPY settings.gradle .

COPY src ./src

COPY build/libs/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
