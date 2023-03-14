FROM ubuntu:22.04

RUN apt-get -y install apache2
RUN apt-get -y install default-jdk
RUN apt-get -y install maven

#COPY /home/ubuntu/target/demo-0.0.1-SNAPSHOT.jar /home/demo-0.0.1-SNAPSHOT.jar
#CMD ["java","-jar","/home/demo-0.0.1-SNAPSHOT.jar"]

EXPOSE 80
