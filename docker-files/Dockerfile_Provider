FROM centos:7

RUN yum -y update && yum clean all

RUN echo yes|yum install glibc.i686

RUN mkdir -p /app && chmod -R 777 /app 

COPY ./jdk-8u211-linux-i586.tar.gz /app/jdk-8u211-linux-i586.tar.gz

COPY ./spring-provider.jar /app/spring-provider.jar

RUN tar -zxvf /app/jdk-8u211-linux-i586.tar.gz

RUN /jdk1.8.0_211/bin/jar -xvf /app/spring-provider.jar

RUN rm -rf /app

EXPOSE 8001

RUN /jdk1.8.0_211/bin/java -jar /microservices-provider-0.0.1-SNAPSHOT.jar
