package com.example.demo;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.ShoeDAO;

@RestController
public class UserController {

	@Autowired
	UserRepo repo;

	
	@Autowired
	UserDAO dao1;
	
	Logger log=Logger.getAnonymousLogger();
	
	
	@RequestMapping("/login")
	public ModelAndView checklogin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String user= request.getParameter("user");
		if((repo.findByuser(user)!=null)&&(repo.findBypassword(request.getParameter("pwd"))!=null)) {
		if(repo.findByuser(user).equals(repo.findBypassword(request.getParameter("pwd"))))
		{
			mv.setViewName("display1.jsp");
			mv.addObject("userid",user);
		}
		}
		else {
			mv.setViewName("fail.jsp");
		}
		
		return mv;
		
	}
	
	@Autowired
	ShoeDAO dao;
	
	@RequestMapping("/getall1")
	public ModelAndView retrieve4(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Shoes> list=dao.getall();
		mv.setViewName("display2.jsp");
		mv.addObject("list",list);
		return mv;
	}
	
	
	RestTemplate rest=new RestTemplate();
@ResponseBody
	@RequestMapping("/registermslogic")
	public String registerms(HttpServletRequest request,HttpServletResponse response) {
		//ModelAndView mv=new ModelAndView();
       
		String user=request.getParameter("user");
		String password=request.getParameter("pwd");
		 int uid=Integer.parseInt(request.getParameter("uid"));
		String email=request.getParameter("email");
		String url="http://localhost:8071/register-user/"+ user+"/"+password+"/"+uid+"/"+email;
		log.info(url);
		rest.getForObject(url,String.class);
		return "registered";
		
	}
	

	@RequestMapping("/user")
	
	public ModelAndView insert1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		User e = new User();
		
	
		e.setUid(Integer.parseInt(request.getParameter("uid")));
		e.setUser(request.getParameter("user"));
		e.setPassword(request.getParameter("password"));
		e.setEmail(request.getParameter("email"));
	
		
		User ep=dao1.insert1(e);
		if(ep!=null) {
			mv.setViewName("adduser.jsp");
		}
		return mv;
		}
	
	@RequestMapping("/deleteuser")
	public ModelAndView deleteproduct(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv=new ModelAndView();
		String user=request.getParameter("user");
		
		dao1.delete(user);
		mv.setViewName("deleteduser.jsp");
		mv.addObject("user",user);
		return mv;
	}
	
	@PutMapping("/updateuser")
	public User update(@RequestBody User e) {
		
		return dao1.updateByName(e);
	
	}
	
	@RequestMapping("/updates")
	public String update() {
		if(repo != null) {
		return "Updated Details";
		}
		return "Not Updated";
	}
	
	
	

	@RequestMapping(value="/bill/{cost}")
	public ModelAndView pay(HttpServletRequest request,HttpServletResponse response,@PathVariable float cost) {
		ModelAndView mv=new ModelAndView();
		
		int shoeid=(Integer.parseInt(request.getParameter("shoeid")));
		int quantity = (Integer.parseInt(request.getParameter("quantity")));
		
		float pay1= cost * quantity;
		
		
		mv.setViewName("display3.jsp");
		mv.addObject("shoeid",shoeid);
		mv.addObject("quantity",quantity);
		mv.addObject("pay1",pay1);
		return mv;
	}
	
	@RequestMapping("/pays")
	public void pay(String cardno, String cname,HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter pw = response.getWriter();
		if(cardno.equals("987 654 321") && (cname.equals("MIRUDULA"))) {
			pw.print("Payment Success");
		}
		else 
			pw.print("Payment Failed");
	}
}
