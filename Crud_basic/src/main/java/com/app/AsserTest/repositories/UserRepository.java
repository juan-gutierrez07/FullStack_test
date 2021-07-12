package com.app.AsserTest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.AsserTest.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public abstract User findByUsername(String Username);
	
}
