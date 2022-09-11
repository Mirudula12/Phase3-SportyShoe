package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Shoes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shoeid;
	private String shoename;
	private float cost;
	
	public Shoes() {
		
	}
	
	public Shoes(String shoename, float cost) {
		super();
		this.shoename = shoename;
		this.cost = cost;
		
	}

	
	@Override
	public String toString() {
		return "Shoes [shoeid=" + shoeid + ", shoename=" + shoename + ", cost=" + cost + "]";
	}
	
	
}	