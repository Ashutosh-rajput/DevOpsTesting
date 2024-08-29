# Stage 1: Build the application
FROM eclipse-temurin:21-jdk-alpine as builder

WORKDIR /app

# Install Maven
RUN apk add --no-cache maven

COPY pom.xml ./
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/TestAwsCiCd.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

## Stage 1: Build the application
#FROM eclipse-temurin:21-jdk-alpine as builder
#
#WORKDIR /app
#
## Copy the necessary files
#COPY mvnw ./
#COPY .mvn .mvn
#COPY pom.xml ./
#
## Ensure the mvnw script is executable
#RUN chmod +x ./mvnw
#
## Download dependencies
#RUN ./mvnw dependency:go-offline -B
#
## Copy the source code
#COPY src ./src
#
## Build the application
#RUN ./mvnw clean package -DskipTests
#
## Stage 2: Create the final image
#FROM eclipse-temurin:21-jre-alpine
#
#WORKDIR /app
#
#EXPOSE 8090
#
## Copy the built jar from the builder stage
#COPY --from=builder /app/target/TestAwsCiCd.jar /app/TestAwsCiCd.jar
#
## Run the application
#ENTRYPOINT ["java", "-jar", "TestAwsCiCd.jar"]

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


