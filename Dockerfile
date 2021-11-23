FROM overcookedpanda/teamcity-agent-openjdk11:latest
ADD target/*.jar app.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "app.jar"]
