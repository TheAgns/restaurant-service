FROM openjdk:17

WORKDIR /usr/src/app

COPY target/springboot-docker-compose.jar /app/springboot-docker-compose.jar
COPY . .
CMD ["java", "-jar", "springboot-docker-compose.jar"]
