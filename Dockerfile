FROM openjdk:11
ADD target/*.jar app.jar
EXPOSE 9696
ENTRYPOINT ["java", "-jar", "app.jar"]
