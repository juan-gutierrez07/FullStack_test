package com.app.AsserTest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usereditdto {

	@JsonProperty(required=true)
	private Long  id;
	@JsonProperty(required=true)
	private String usernew;
	@JsonProperty(required=true)
	private String passnew;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsernew() {
		return usernew;
	}
	public void setUsernew(String usernew) {
		this.usernew = usernew;
	}
	public String getPassnew() {
		return passnew;
	}
	public void setPassnew(String passnew) {
		this.passnew = passnew;
	}
	
	
}
