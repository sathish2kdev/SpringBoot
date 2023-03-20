package com.app.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ProfileApplication implements CommandLineRunner  {
	
	 private static final Logger logger = LoggerFactory.getLogger(ProfileApplication.class);

	    private final Environment env;

	    public ProfileApplication(Environment env) {
	        this.env = env;
	    }


	public static void main(String[] args) {
		SpringApplication.run(ProfileApplication.class, args);
		
	}
	
	  @Override
	    public void run(String... args) throws Exception {

	        logger.info("{}", env.getProperty("JAVA_HOME") + "1");
	        logger.info("{}", env.getProperty("app.name"));
	    }


	
}
