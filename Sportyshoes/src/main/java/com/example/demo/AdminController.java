package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {

	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	ShoeRepo repo2;
	
	@Autowired
	ShoeDAO dao;
	
	@RequestMapping("/")

	public ModelAndView intializerpage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
	
	@RequestMapping("/adminlogin")
	public String adminLogin(HttpServletRequest request,HttpServletResponse response)  {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	
		
        if(adminRepo.findByusername(username).equals(adminRepo.findBypassword(password))) {
        	
        	return "<html> "
			+ "<body>" 
			+ "<h1>Welcome to Admin Page</h1>"
			+ "<form action='shoes.jsp'>"
			+ "<br>"
			+ "<input type='submit' value='shoes'>"
			+ "</form>"
			+ "<br>"
			+ "<form action='users.jsp'>"
			+ "<br>"
			+ "<input type='submit' value='users'>"
			+ "</form>"
			+ "</body>"
			+ "</html>"	
			;
			
        }
		else {
			
			return "<html> "
					+ "<body>" 
					+ "<h1>Invalid</h1>"
					+ "<form action='admin.jsp'>"
					+ "<br>"
					+ "<input type='submit' value='Return to Admin Login'>"
					+ "</form>"
					+ "</body>"
					+ "</html>"	
					;
		}
	}
	
	@RequestMapping("/getalluser")
	public ModelAndView getusers(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<User> list=dao.getallusers();
		mv.setViewName("displayuser.jsp");
		mv.addObject("list",list);
		return mv;
	}
	
	
	@PutMapping("/update")
	public Shoes updateByName(@RequestBody Shoes e) {
		
		return dao.updateById(e);
	
	}
	
	@RequestMapping("/updates")
	public String update() {
		if(repo2 != null) {
		return "Updated Details";
		}
		return "Not Updated";
	}

	
	
}
