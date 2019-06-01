package com.amazon.cloud.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MySelfRule
{
	@Bean
	public IRule myRule()
	{
		//return new RandomRule();// Ribbon default
		//return new RoundRobinRule();
		return new RandomRuleEnhanced();
		//return new RetryRule();
	}
}
