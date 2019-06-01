package com.amazon.cloud;

/**
 *  to test server is up and running: http://localhost:3344/application-dev.yml
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer
{
	public static void main(String[] args)
	{
		SpringApplication.run(ConfigServer.class, args);
	}
}
