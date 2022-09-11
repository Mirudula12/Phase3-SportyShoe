package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {

@Autowired
UserRepo repo;


	
	public User insert1(User e) {
		return repo.save(e);
	}
	
	
	public List<User> getall() {
		return repo.findAll();
	}
	
	public List<User> getallusers() {
		return repo.findAll();
	}
	

	public void delete(String user) {
		repo.deleteById(user);
	}
	
	
	public User updateByName(User e) {
	
		User ee=repo.findById(e.getUid()).orElse(null);
		ee.setPassword(e.getPassword());
		ee.setEmail(e.getEmail());
		return repo.save(ee);
		
	
		
	}
	
	
}
