FROM openjdk:11
COPY target/*.jar homework.jar
ENTRYPOINT ["java", "-jar", "homework.jar"]