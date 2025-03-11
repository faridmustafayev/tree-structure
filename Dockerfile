FROM openjdk:17-alpine

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew clean build

COPY build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
