package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface AdminRepo extends JpaRepository<Admin, Integer> {

	@Query("select admin from Admin admin where admin.username=?1")
	public Admin findByusername(String name);
	
	@Query("select admin from Admin admin where admin.password=?1")
	public Admin findBypassword(String name);
}
