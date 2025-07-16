FROM openjdk:17-jdk-slim
WORKDIR /appdocker build --platform linux/amd64 -t your-image-name .
COPY build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]