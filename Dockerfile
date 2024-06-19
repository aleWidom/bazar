
FROM openjdk:17-jdk-slim
ARG JAR_FILE=out/artifacts/bazar_jar/bazar.jar
COPY ${JAR_FILE} bazar.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bazar.jar"]




