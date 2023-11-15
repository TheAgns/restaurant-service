FROM openjdk:17

WORKDIR /app

COPY target/springboot-docker-compose.jar /app/springboot-docker-compose.jar

CMD ["java", "-jar", "springboot-docker-compose.jar"]
