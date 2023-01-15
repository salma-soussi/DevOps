# Docker Build Maven Stage
FROM maven:3-jdk-11-alpine AS build
# Copy folder in docker
WORKDIR /app
COPY ./ /app
RUN mvn clean install -DskipTests
# Run spring boot in Docker
FROM openjdk:11-jdk-alpine
COPY --from=build /app/target/*.jar app.jar
ENV PORT 8090
EXPOSE $PORT
ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","backend.jar"]
