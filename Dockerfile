FROM openjdk:8

MAINTAINER XYZ
 
ADD target/demo-0.0.1-SNAPSHOT.jar demo.jar

CMD ["java", "-jar", "demo.jar"]

FROM mysql:5.7

ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=
ENV MYSQL_DATABASE="carbook" \
    MYSQL_DATA_DIR=/var/lib/mysql \
    MYSQL_RUN_DIR=/run/mysqld \
    MYSQL_LOG_DIR=/var/log/mysql
   
    
    
#USER root

COPY carbook.sql /docker-entrypoint-initdb.d/

RUN /etc/init.d/mysql start && mysql -u root  -e "CREATE USER $MYSQL_USER@'localhost';GRANT ALL PRIVILEGES ON *.* TO $MYSQL_USER@'localhost' WITH GRANT OPTION; FLUSH PRIVILEGES;" && mysql -u $MYSQL_USER $MYSQL_DATABASE  < /docker-entrypoint-initdb.d/carbook.sql

EXPOSE 8080 3306/tcp
