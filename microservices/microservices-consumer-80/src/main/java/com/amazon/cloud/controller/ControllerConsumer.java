package com.amazon.cloud.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ControllerConsumer {
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-CONFIG-PROVIDER-CLIENT";
	private static final int DELAY = 10;	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/get")
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public String get() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		final Future<String> handler = executor.submit(new Callable() {
			@Override
			public String call() throws Exception {
				return restTemplate.getForObject(REST_URL_PREFIX + "/get/", String.class);
			}

		});
		executor.schedule(new Runnable() {
			public void run() {
				handler.cancel(true);
			}
		}, DELAY * 1000, TimeUnit.MILLISECONDS);
		
		try {
			return handler.get();
		} catch (InterruptedException e) {
			throw new RuntimeException("No response in 10 seconds.");
		} catch (ExecutionException e) {
			throw new RuntimeException("No response in 10 seconds.");
		}		
	}
	
	public String processHystrix_Get() {
		return "Server is busy so he has no time to response.";
	}
	
}
