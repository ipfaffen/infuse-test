FROM amazoncorretto:24
WORKDIR /app
COPY target/infuse-test-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]