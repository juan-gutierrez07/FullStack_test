package com.app.AsserTest.dto.rp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsdtoRp {


	@JsonProperty(required=true)
	private String user;
	@JsonProperty(required=true)
	private String msg;
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
