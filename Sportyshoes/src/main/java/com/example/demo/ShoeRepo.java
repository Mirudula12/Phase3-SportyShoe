package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeRepo extends JpaRepository<Shoes, Integer> {
	
}
