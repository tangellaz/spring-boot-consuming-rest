FROM openjdk:19-jdk-oracle
ADD target/assessment-0.0.1.jar assessment.jar
ENTRYPOINT ["java","-jar","/assessment.jar"]