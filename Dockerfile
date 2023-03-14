FROM anapsix/alpine-java

COPY /home/ubuntu/target/demo-0.0.1-SNAPSHOT.jar /home/demo-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/demo-0.0.1-SNAPSHOT.jar"]
