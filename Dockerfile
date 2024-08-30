## Stage 1: Build the application with a Maven image
#FROM maven:3.9.4-eclipse-temurin-21-alpine as builder
#
#WORKDIR /app
#
## Copy only the necessary files first to leverage Docker cache
#COPY pom.xml ./
#RUN mvn dependency:go-offline -B
#
## Copy the source code and package the application
#COPY src ./src
#RUN mvn clean package -DskipTests

# Stage 2: Create the final image with a minimal runtime environment
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

EXPOSE 8080

#ARG JAR_FILE=target/TestAwsCiCd.jar
#ADD ${JAR_FILE} app.jar
#COPY target/TestAwsCiCd.jar app.jar

# Copy the packaged jar from the builder stage
COPY target/TestAwsCiCd.jar app.jar

# Use optimized JVM options to reduce memory usage
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "/app.jar"]







## Stage 1: Build the application
#FROM eclipse-temurin:21-jdk-alpine as builder
#
#WORKDIR /app
#
## Install Maven
#RUN apk add --no-cache maven
#
#COPY pom.xml ./
#RUN mvn dependency:go-offline -B
#
#COPY src ./src
#
#RUN mvn clean package -DskipTests
#
## Stage 2: Create the final image
#FROM eclipse-temurin:21-jre-alpine
#
#WORKDIR /app
#
#COPY --from=builder /app/target/TestAwsCiCd.jar app.jar
#
#ENTRYPOINT ["java", "-jar", "app.jar"]





## Stage 1: Build the application
#FROM eclipse-temurin:21-jdk-alpine as builder
#
#WORKDIR /app
#
#COPY mvnw ./
#COPY .mvn .mvn
#
#COPY pom.xml ./
#
#RUN ./mvnw dependency:go-offline -B
#
#COPY src ./src
#
#RUN ./mvnw clean package -DskipTests
#
## Stage 2: Create the final image
##FROM eclipse-temurin:21-jre-alpine
#FROM eclipse-temurin:21-jre-alpine
#
#WORKDIR /app
#
#EXPOSE 8090
#
##ARG JAR_FILE=target/TestAwsCiCd.jar
##ADD ${JAR_FILE} TestAwsCiCd.jar
#
#COPY --from=builder /app/target/TestAwsCiCd.jar /app/TestAwsCiCd.jar
#
#ENTRYPOINT ["java", "-jar", "TestAwsCiCd.jar"]


