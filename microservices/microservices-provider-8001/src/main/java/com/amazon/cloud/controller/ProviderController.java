package com.amazon.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.cloud.service.ProviderService;

@RestController
public class ProviderController {
	@Autowired
	private ProviderService service;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get() {
		return service.get();
	}
}
