package com.example.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, String>{

	@Query("select user from User user where user.user=?1")
	public User findByuser(String name);
	
	@Query("select user from User user where user.password=?1")
	public User findBypassword(String name);

	
	
}


