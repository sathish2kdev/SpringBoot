package com.app.profile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.profile.service.ServiceImpl;

@SpringBootTest
class ProfileApplicationTests {

	@Autowired
	ServiceImpl service;
	
//	@Test
	void contextLoads() throws Exception {
		service.justPrint();
//		service.justPrintWithValue(null);
	}

}
