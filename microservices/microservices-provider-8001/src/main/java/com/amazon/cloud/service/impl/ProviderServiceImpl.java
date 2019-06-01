package com.amazon.cloud.service.impl;

import org.springframework.stereotype.Service;

import com.amazon.cloud.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService
{
	@Override
	public String get() {
		return "Hello AWS";
	}

}
