# Etapa de construcción
FROM maven:3.8.1-openjdk-17 AS build
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17-jdk-slim
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
