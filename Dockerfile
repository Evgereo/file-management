FROM maven:3.8.3-openjdk-17 AS builder
LABEL authors="Evgereo"

WORKDIR /app

COPY src ./src
COPY pom.xml ./

RUN mvn clean verify

FROM openjdk:17 AS runner

WORKDIR /app

COPY --from=builder /app/target/file-management-0.0.1-SNAPSHOT.jar file-management.jar

CMD ["java","-jar","/app/file-management.jar"]

EXPOSE 9090
