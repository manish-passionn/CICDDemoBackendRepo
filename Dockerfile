# Use a lightweight Java 17 runtime
#FROM public.ecr.aws/bitnami/eclipse-temurin:17-jdk
FROM public.ecr.aws/jht/eclipse-temurin:17-jdk

#FROM bitnami/eclipse-temurin:17

# Set working directory
WORKDIR /app

# Copy the built Java application (JAR file)
COPY target/*.jar app.jar

# Expose the port your Java app listens on (commonly 8080)
EXPOSE 8080

# Run the Java application
ENTRYPOINT ["java", "-jar", "app.jar"]
