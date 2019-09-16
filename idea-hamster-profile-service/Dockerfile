FROM openjdk:11
ADD ./target/idea-hamster-profile-service-0.0.1-SNAPSHOT.jar /usr/src/idea-hamster-profile-service-0.0.1-SNAPSHOT.jar
ADD ./src/main/resources/ih-profile-service.xlsx /usr/src/ih-profile-service.xlsx
WORKDIR usr/src
ENTRYPOINT ["java","-jar","idea-hamster-profile-service-0.0.1-SNAPSHOT.jar"]