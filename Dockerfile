FROM adoptopenjdk/openjdk17:alpine-jre

WORKDIR /app

COPY build/libs/mi-aplicacion.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]