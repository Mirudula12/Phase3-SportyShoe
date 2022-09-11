package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
@Id

private String user;
private String password;
private int uid;
private String email;
	
	
}

