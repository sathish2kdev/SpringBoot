package com.app.profile.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class Test {

	public Test() {
		System.out.println("Test Profile Implemented");
	}

	
}
