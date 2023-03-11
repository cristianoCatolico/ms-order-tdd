FROM ubuntu
COPY api-service/target/ /app
RUN apt-get update
RUN apt-get -y install openjdk-17-jdk
RUN apt-get -y install vim
CMD ["java","-jar","/app/api-service-0.0.1-SNAPSHOT.jar"]