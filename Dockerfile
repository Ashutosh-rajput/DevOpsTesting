# Stage 1: Build the application
FROM eclipse-temurin:22-jdk-alpine as builder

WORKDIR /app

COPY mvnw ./
COPY .mvn .mvn

COPY pom.xml ./

RUN ./mvnw dependency:go-offline -B

COPY src ./src

RUN ./mvnw clean package -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:22-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/TestAwsCiCd.jar /app/TestAwsCiCd.jar

ENTRYPOINT ["java", "-jar", "TestAwsCiCd.jar"]
