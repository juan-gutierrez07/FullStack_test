package com.app.AsserTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.AsserTest.dto.Userdto;
import com.app.AsserTest.dto.Usereditdto;
import com.app.AsserTest.services.IUserServiceJPA;

@RequestMapping(value="/users")
@RestController
public class UserController {
	
	@Autowired
	private IUserServiceJPA UseServi;
	
	
	@PostMapping(value="/add")
	public String addUSer(@RequestBody Userdto userdto) 
	{
		
		return UseServi.addUser(userdto);
	}
	
	@GetMapping(value="/getUser")
	public String getUs(@RequestBody String Username) {
		
		return UseServi.getUs(Username);
		
	}
	
	@GetMapping(value="/getAll")
	public String getAll(){
		
		return UseServi.ListUsers();
	}
	
	@DeleteMapping(value="/delete")
	public String deleteUs(@RequestBody Userdto us){
		
		return UseServi.DeleteUser(us);
	}
	
	@PutMapping(value="/editUs")
	public String EditUs(@RequestBody Usereditdto user){
		
		return UseServi.EditUs(user);
	}

	@GetMapping(value="/welcome")
	public String Welcome(){
		
		return "Bienvenido";
	}

	@GetMapping(value="/v1.1.0/hotfix")
	public String Welcome(){
		
		return "Bienvenido a la rama hotfix";
	}

	@GetMapping(value="/v1.2.0/feature2")
	public String Welcome(){
		
		return "Bienvenido a la rama feature2";
	}
}
