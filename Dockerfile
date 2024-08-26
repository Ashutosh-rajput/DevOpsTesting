## Stage 1: Build the application
#FROM eclipse-temurin:22-jdk-alpine as builder
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

# Stage 2: Create the final image
#FROM eclipse-temurin:21-jre-alpine
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

ARG JAR_FILE=target/TestAwsCiCd.jar
ADD ${JAR_FILE} TestAwsCiCd.jar

#COPY --from=builder /app/target/TestAwsCiCd.jar /app/TestAwsCiCd.jar

ENTRYPOINT ["java", "-jar", "TestAwsCiCd.jar"]


