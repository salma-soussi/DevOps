# Docker Build Maven Stage
FROM maven:3-openjdk-17-slim AS build
# Copy folder in docker
WORKDIR /app
COPY ./ /app
RUN mvn clean install -DskipTests
# Run spring boot in Docker
FROM tomcat:latest
ADD /app/target/*.war /usr/local/tomcat/webapps/
EXPOSE 8090
CMD ["catalina.sh", "run"]
