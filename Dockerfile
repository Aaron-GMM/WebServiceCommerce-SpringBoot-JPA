FROM ubuntu:23.10 AS build

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install -DskipTests

WORKDIR /app

FROM openjdk:21-jdk-slim

EXPOSE 8080

COPY --from=build /target/*.jar /ursospring/cursospring.jar

ENTRYPOINT [ "java", "-jar", "/cursospring/cursospring.jar" ]