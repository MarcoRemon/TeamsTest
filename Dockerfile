FROM openjdk:17

WORKDIR /app

COPY gradle/ ./gradle/
COPY gradlew ./

COPY build.gradle .
COPY settings.gradle .

COPY src ./src

RUN ./gradlew clean build -x test

COPY build/libs/teamtest.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
