package com.amazon.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // Register to Eureka
@EnableDiscoveryClient //Service discovery
public class ServiceProvider
{
	public static void main(String[] args)
	{
		SpringApplication.run(ServiceProvider.class, args);
	}
}
