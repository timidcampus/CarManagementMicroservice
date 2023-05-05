# Use the official OpenJDK 17 base image
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the Maven pom.xml file into the working directory
COPY pom.xml .

# Install any missing dependencies
RUN mvn dependency:go-offline

# Copy the source code into the working directory
COPY src ./src

# Package the application
RUN mvn package -DskipTests

ENTRYPOINT ["java", "-jar", "target/car-management-microservice-0.0.1-SNAPSHOT.jar"]