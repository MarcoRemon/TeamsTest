FROM gradle:7.5-jdk17 as build

WORKDIR /home/gradle/src

COPY build.gradle settings.gradle ./

COPY src ./src

RUN gradle build --no-daemon

FROM openjdk:17-jdk-alpine

COPY --from=build /home/gradle/src/build/libs/*.jar /app.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
