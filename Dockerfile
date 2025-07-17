FROM openjdk:21
ADD target/learner-service-0.0.1-SNAPSHOT.jar learner-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "learner-service.jar"]