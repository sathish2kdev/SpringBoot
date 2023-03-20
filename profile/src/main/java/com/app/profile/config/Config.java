package com.app.profile.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my")
public class Config {

	private String message;
	private int usercount;
	private String contactinfo;
	private String env;
	private String thankyoumessage;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getUsercount() {
		return usercount;
	}

	public void setUsercount(int usercount) {
		this.usercount = usercount;
	}

	public String getContactinfo() {
		return contactinfo;
	}

	public void setContactinfo(String contactinfo) {
		this.contactinfo = contactinfo;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getThankyoumessage() {
		return thankyoumessage;
	}

	public void setThankyoumessage(String thankyoumessage) {
		this.thankyoumessage = thankyoumessage;
	}

}
