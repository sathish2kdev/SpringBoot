package com.app.profile.resttemplate.exceptionhandler;

import org.springframework.http.HttpStatus;

public class MyRestTemplateException extends RuntimeException {

	private DownstreamApi downStreamApi;
	private HttpStatus status;
	private String error;

	public MyRestTemplateException(DownstreamApi downStreamApi, HttpStatus status, String error) {
		super(error);
		this.downStreamApi = downStreamApi;
		this.status = status;
		this.error = error;
	}

	public DownstreamApi getDownStreamApi() {
		return downStreamApi;
	}

	public void setDownStreamApi(DownstreamApi downStreamApi) {
		this.downStreamApi = downStreamApi;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
