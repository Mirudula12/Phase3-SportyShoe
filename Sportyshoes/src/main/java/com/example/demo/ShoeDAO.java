package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoeDAO {
@Autowired
ShoeRepo repo;

@Autowired
UserRepo repo1;
	
	public Shoes insert(Shoes a) {
		return repo.save(a);
	}
	
	
	public List<Shoes> getall() {
		return repo.findAll();
	}
	
	public List<User> getallusers() {
		return repo1.findAll();
	}
	
	public Shoes getbyid(int shoeid) {
		return repo.getById(shoeid);
		
	}
	
	
	public void delete(int shoeid) {
		repo.deleteById(shoeid);
	}
	
	public Shoes updateById(Shoes e) {
		//1.we fetch the record from the table
		Shoes ee=repo.findById(e.getShoeid()).orElse(null);
		ee.setShoename(e.getShoename());
		ee.setCost(e.getCost());
		return repo.save(ee);
		
	
		
	}

	


	
	/*public Product updateByName(Product e) {
		Product ee=repo.findById(e.getEmpno()).orElse(null);
		ee.setEmpname(e.getEmpname());
		return repo.save(ee);
	}*/
}
