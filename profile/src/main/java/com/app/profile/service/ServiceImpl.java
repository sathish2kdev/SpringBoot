package com.app.profile.service;

import org.springframework.stereotype.Service;

import com.app.profile.aop.Log;

@Service
public class ServiceImpl {

//	@Log
	public void justPrint() {
		System.out.println("hello");
	}
	
	public void justPrintWithValue(Long id) throws Exception {
		
		try {
			double d = id/2;
			System.out.println("MY ID IS : "+d);
		} catch (Exception e) {
//			e.printStackTrace();
			throw new Exception(e);
		}
		
	}
}
