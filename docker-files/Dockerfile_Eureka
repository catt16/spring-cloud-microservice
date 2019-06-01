FROM centos:7

RUN yum -y update && yum clean all

RUN echo yes|yum install glibc.i686

RUN mkdir -p /app && chmod -R 777 /app 

COPY ./jdk-8u211-linux-i586.tar.gz /app/jdk-8u211-linux-i586.tar.gz

COPY ./spring-eureka.jar /app/spring-eureka.jar

RUN tar -zxvf /app/jdk-8u211-linux-i586.tar.gz

RUN /jdk1.8.0_211/bin/jar -xvf /app/spring-eureka.jar

RUN rm -rf /app

EXPOSE 7001

RUN /jdk1.8.0_211/bin/java -jar /microservices-eureka-0.0.1-SNAPSHOT.jar
