package com.app.profile.resttemplate.exceptionhandler.impl;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.profile.resttemplate.exceptionhandler.MyApiRestTemplateErrorHandler;
import com.app.profile.resttemplate.exceptionhandler.RestService;

@Service
public class RestServiceImpl implements RestService {

//	@Autowired
	RestTemplate restTemplate;

	public RestServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.errorHandler(new MyApiRestTemplateErrorHandler()).build();
	}

	@Override
	public String getData() {
		return restTemplate.getForObject("http://localhost:3000/login-detail", String.class);
	}
}
