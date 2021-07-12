package com.app.AsserTest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.AsserTest.dto.Userdto;
import com.app.AsserTest.dto.Usereditdto;
import com.app.AsserTest.dto.rp.UsdtoRp;
import com.app.AsserTest.models.User;
import com.app.AsserTest.repositories.UserRepository;
import com.google.gson.Gson;


@Service
public class UserServiceJPA implements IUserServiceJPA {

	@Autowired
	private UserRepository UsRepo;
	String JSON = null ,json1=null, json2 = null;
	@Override
	public String addUser(Userdto user) {
		
		try {
			System.out.println(user.getUser());
			System.out.println(user.getPassw());
			UsdtoRp resp = new UsdtoRp();
			User us = new User();
			if(UsRepo.findByUsername(user.getUser()) != null) {
				resp.setUser(us.getUsername());
				resp.setMsg("Usurname en uso, uso otro por favor !");
				json1 = new Gson().toJson("412");
				json2 = new Gson().toJson(resp);
				
			}else {
				us.setUsername(user.getUser());
				us.setPassword(user.getPassw());
				UsRepo.save(us);
				resp.setUser(us.getUsername());
				resp.setMsg("Welcome");
				json1 = new Gson().toJson("200");
				json2 = new Gson().toJson(resp);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			json1 = new Gson().toJson("500");
			json2 = new Gson().toJson(null);
		}
		
		return JSON = "["+json1+","+json2+"]";
	}
	
	@Override
	public String getUs(String username) {
		
		UsdtoRp resp = new UsdtoRp();
		try {
			System.out.println(username);
			User us = UsRepo.findByUsername(username);
			System.out.println(us);
			if(us != null){
				resp.setUser(us.getUsername());
				resp.setMsg("Bienvenido");
				json1 = new Gson().toJson("200");
				json2 = new Gson().toJson(resp);	
				
			}else{
				json1 = new Gson().toJson("404");
				json2 = new Gson().toJson("Usuario no agregado !");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			json1 = new Gson().toJson("500");
			json2 = new Gson().toJson(null);
			
		}
		
		return JSON = "["+json1+","+json2+"]";
	}
	
	@Override
	public String ListUsers() {
		
		List<User> users = UsRepo.findAll();
		try {
			json1 = new Gson().toJson("200");
			json2 = new Gson().toJson(users);	
			
		} catch (Exception e) {
			json1 = new Gson().toJson("500");
			json2= new Gson().toJson(null);
		}
		
		return  JSON = "["+json1+","+json2+"]";
	}
	
	@Override
	public String DeleteUser(Userdto user) {
		
		try {
			User us = UsRepo.findByUsername(user.getUser());
			if(us != null){
				UsRepo.deleteById(us.getId());
				json1 = new Gson().toJson("200");
				json2 = new Gson().toJson("Usuario Eliminado !");
			}else{
				json1 = new Gson().toJson("404");
				json2 = new Gson().toJson("El usuario no existe");
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
			json1 = new Gson().toJson("500");
			json1 = new Gson().toJson(null);
			
		}
		
		return  JSON = "["+json1+","+json2+"]";
	}

	@Override
	public String EditUs(Usereditdto userinfo) {
		
		try {
			User us = UsRepo.findById(userinfo.getId()).orElse(null);
			
			if(us != null) {
				us.setUsername(userinfo.getUsernew());
				us.setPassword(userinfo.getPassnew());
				UsRepo.save(us);
				json1 = new Gson().toJson("200");
				json2 = new Gson().toJson("Usuario editado !");
			}else {
				json1 = new Gson().toJson("404");
				json2 = new Gson().toJson("El usuario no existe !");
			}
			
		} catch (Exception e) {
			json1 = new Gson().toJson("500");
			json2 = new Gson().toJson(null);
		}
		
		return  JSON = "["+json1+","+json2+"]";
	}
	
}
