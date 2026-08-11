# Stage 1: Build
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copia pom e dependências antes para cache
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código fonte
COPY src ./src

# Compila e empacota a aplicação
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copia o jar gerado no build
COPY --from=build /app/target/backend-institucional-service-1.0-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8000

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar", "-Dspring.profiles.active=docker"]
