FROM openjdk:11
COPY target/*.jar homework_k8s-2.jar
ENTRYPOINT ["java", "-jar", "homework_k8s-2.jar"]