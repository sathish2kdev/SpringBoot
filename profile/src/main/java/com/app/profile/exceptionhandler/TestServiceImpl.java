package com.app.profile.exceptionhandler;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public void returnException(){
		try {
			String data = null;
			data.toString();
		}catch (NullPointerException e) {
			throw new NullPointerException(e.getMessage());
		}
		
//		catch (Exception e) {
			throw new InvalidDataException("Invalid Data Found");
//		}
//		throw new DataNotFoundException("Data Not Found");
		
		
	}
}
