#pull jdk image
FROM openjdk:11
#add/copy jar file from target to docker file system
ADD ./target/idea-service-0.0.1-SNAPSHOT.jar /usr/src/idea-service-0.0.1-SNAPSHOT.jar
ADD ./src/main/resources/idea-service.xlsx /usr/src/idea-service.xlsx
WORKDIR usr/src
#run the jar file
ENTRYPOINT ["java","-jar","idea-service-0.0.1-SNAPSHOT.jar"]





