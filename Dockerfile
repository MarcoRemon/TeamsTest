FROM openjdk:17

WORKDIR /app

COPY build.gradle .
COPY settings.gradle .
COPY gradlew .

COPY gradle/ ./gradle/

COPY src ./src

RUN ./gradlew clean build -x test

COPY --from=build /app/build/libs/demo.jar .

ENTRYPOINT ["java","-jar","/app.jar"]