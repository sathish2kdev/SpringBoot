package com.app.profile.resttemplate.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

	@Autowired
	RestService restService;

	@GetMapping("/resttemplate")
	public void analyizeRest() {
		String data = restService.getData();
		System.out.println(data);
	}
}
