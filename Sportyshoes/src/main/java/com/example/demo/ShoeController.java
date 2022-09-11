package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoeController {
@Autowired
ShoeDAO dao;


@RequestMapping("/shoe")

	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Shoes a = new Shoes();
		

		
		a.setShoename(request.getParameter("shoename"));
		a.setCost(Float.parseFloat(request.getParameter("cost")));
		
		
		Shoes ep=dao.insert(a);
		if(ep!=null) {
			mv.setViewName("display.jsp");
		}
		return mv;
		}

@RequestMapping("/getall")
public ModelAndView retrieve(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	List<Shoes> list=dao.getall();
	mv.setViewName("displayresult.jsp");
	mv.addObject("list",list);
	return mv;
}

@RequestMapping("/getuserall")
public ModelAndView retrieve1(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	
	List<Shoes> list=dao.getall();
	mv.setViewName("displayresult1.jsp");
	mv.addObject("list",list);
	return mv;
}
	


@RequestMapping("/delete")
public ModelAndView deleteproduct(HttpServletRequest request,HttpServletResponse response) {
	
	ModelAndView mv=new ModelAndView();
	int shoeid=(Integer.parseInt(request.getParameter("shoeid")));
	
	dao.delete(shoeid);
	mv.setViewName("deleted.jsp");
	mv.addObject("shoeid",shoeid);
	return mv;
}

}
