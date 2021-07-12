package com.app.AsserTest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Userdto {


	@JsonProperty(required=true)
	private String user;
	@JsonProperty(required=true)
	private String passw;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	
	
}

