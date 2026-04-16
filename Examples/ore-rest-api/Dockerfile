FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw pom.xml ./

# Download dependencies (cached layer)
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build application
RUN ./mvnw clean package -DskipTests -B

# Expose port
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "target/ore-rest-api-1.0.0.jar"]
