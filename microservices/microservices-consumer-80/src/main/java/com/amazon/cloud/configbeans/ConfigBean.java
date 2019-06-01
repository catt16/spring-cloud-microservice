package com.amazon.cloud.configbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {
	@Bean
	@LoadBalanced // Spring Cloud Ribbon is based on Netflix Ribbon and the client side tool for
					// load balancing。
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public IRule myRule() {
		// return new RoundRobinRule();
		// return new RandomRule();
		return new RetryRule();
	}
}
