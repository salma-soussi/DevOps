# Docker Build Maven Stage
FROM maven:3-openjdk-17-slim AS build
# Copy folder in docker
WORKDIR /app
COPY ./ /app
RUN mvn clean install -DskipTests
# Run spring boot in Docker
FROM openjdk:17-jdk-slim
COPY --from=build /app/target/*.jar backend.jar
ENV PORT 8090
EXPOSE $PORT
ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","backend.jar"]
