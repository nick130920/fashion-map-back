FROM openjdk:21-jdk
COPY target/fashion-0.0.1-SNAPSHOT.jar /app/fashion-0.0.1-SNAPSHOT.jar
EXPOSE 8082
CMD ["java", "-jar", "/app/fashion-0.0.1-SNAPSHOT.jar"]
