# spring-cloud-microservice

Sample microservice implementations based on Spring Boot Framework and Spring Cloud ecosystem.

![alt tag](https://user-images.githubusercontent.com/5929519/58834535-3b4aac80-8686-11e9-8687-0ad7f7332e3c.png)

There are 4 sample microservices: 

1. Spring Cloud Config Server
   Config Server works as the centralized configuration component which is used by Eureka Server and Service Provider Service. 
   The configuration files stored in GitHub repository which is monitored/watched by Config Server. Once the configuration file
   has any update the Config Server will refresh its memory accordingly and notify the changes to its consumers (Eureka Server 
   and Service Provider).
   
2. Spring Cloud Eureka Server
   Eureka Server is the service register center. It works as system registration center serving the service register from any 
   service providers so that service consumer can do service discovery from it. Eureka server provide better high availability
   agaist Zookeeper. It reads configurations from Config Server.
   
3. Spring Cloud Service Provider
   Sample project of Service provider. This service serves the http request (Get) and response with "Hello AWS". It registers
   into Eureka Server and reads configurations from Config Server.
   
4. Spring Cloud Service Consumer
   Sample project of Server Consumer. This service finds the service provider from Eureka Server and call service provider.
   Finally, it returns "Hello AWS" to users.
   Service Consumer uses the Spring Could Ribbon as the client side load balancer.
   Service Consumer uess the Spring Cloud Hystrix as the fallback once the service is broken.

5. Dockerfile is in src/ folder for each microservice. The built image size differs from 130M to 150M.

   "docker build --rm -t config:latest ."
   
   "docker tag config:latest 573880122646.dkr.ecr.ap-southeast-1.amazonaws.com/centos7:config"
   
   "docker push 573880122646.dkr.ecr.ap-southeast-1.amazonaws.com/centos7:config"
   
   ![alt tag](https://user-images.githubusercontent.com/5929519/58835819-8adea780-8689-11e9-924d-480dcf6e536b.png)

6. Reference
   https://spring.io/
