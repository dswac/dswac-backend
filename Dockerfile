FROM maven:3-jdk-8-alpine

WORKDIR /usr/src/app

ADD target/Api-BackEnd-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8090
#CMD [ "sh", "-c", "mvn -Dserver.port=${PORT} spring-boot:run" ]
