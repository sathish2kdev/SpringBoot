package com.app.profile.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class Prod {

	public Prod() {
		System.out.println("Production Server Enabled");
	}
	
}
