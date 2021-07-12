package com.app.AsserTest.services;

import com.app.AsserTest.dto.Userdto;
import com.app.AsserTest.dto.Usereditdto;

public interface IUserServiceJPA {
	
	public abstract String addUser(Userdto user);
	
	public abstract String getUs(String username);
	
	public abstract String ListUsers();
	
	public abstract String DeleteUser(Userdto us);
	
	public abstract String EditUs(Usereditdto userinfo);

}
