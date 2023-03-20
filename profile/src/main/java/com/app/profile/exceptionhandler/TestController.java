package com.app.profile.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	TestService testService;
	
	@GetMapping("/testData")
	public ResponseEntity<?> validateData(){
		
			testService.returnException();
			return new ResponseEntity<>("OK",HttpStatus.OK);
		
		
	}
}
