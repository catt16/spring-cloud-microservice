FROM openjdk:8-jre-alpine
ADD target/spring-config.jar /app.jar
ENV JAVA_OPTS=""
RUN unzip /app.jar
RUN rm -f /app.jar
RUN mv /microservices-config-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
EXPOSE 3344