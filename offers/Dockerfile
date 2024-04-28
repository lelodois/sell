FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
LABEL authors="leozito"
COPY build/libs/offers-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]