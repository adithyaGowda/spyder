FROM openjdk:11
ADD ./target/service-provider-profile-service-0.0.1-SNAPSHOT.jar /usr/src/service-provider-profile-service-0.0.1-SNAPSHOT.jar
ADD ./src/main/resources/sp-profile-service.xlsx /usr/src/sp-profile-service.xlsx
WORKDIR usr/src
ENTRYPOINT ["java","-jar","service-provider-profile-service-0.0.1-SNAPSHOT.jar"]





