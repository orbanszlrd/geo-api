# syntax=docker/dockerfile:1

FROM maven:3.6.3-jdk-11-slim AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests

FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine
RUN apk add dumb-init
RUN mkdir /app
RUN addgroup --system appuser && adduser -S -s /bin/false -G appuser appuser
COPY --from=build /project/target/geo-0.0.1-SNAPSHOT.jar /app/geo.jar
WORKDIR /app
RUN chown -R appuser:appuser /app
USER appuser
CMD "dumb-init" "java" "-jar" "geo.jar"


