package com.amazon.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.amazon.cloud.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-CONFIG-PROVIDER-CLIENT", configuration = MySelfRule.class)
public class ServiceConsumer {
	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumer.class, args);
	}
}
