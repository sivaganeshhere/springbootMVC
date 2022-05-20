package com.nit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nit.service.ImplService;

@Controller
public class wishMessageController {
	
	@Autowired
	private ImplService service;
	
	@RequestMapping("/home")
	public String homepage() {
		return "welcome";
	}
	/*@RequestMapping("/wish")
	public ModelAndView fetchMessage() {
		String msg=service.wishMessage();
		ModelAndView mav=new ModelAndView();
		mav.addObject("wMsg",msg);
		mav.addObject("sysDate",new Date());
		mav.setViewName("show_result");
		return mav;
	}*/
	/*@RequestMapping("/wish")
	public String fetchMessage(Map<String,Object> map) {
		String msg=service.wishMessage();
		map.put("wMsg", msg);
		map.put("sysDate",new Date());
		return "show_result";
	}*/
	//writing response directly to browser without using viewresolver and view component
	@RequestMapping("/wish")
	public String fetchWishMessage(HttpServletResponse res) throws Exception {
		String msg=service.wishMessage();
		PrintWriter pw=res.getWriter();
		pw.println("<b> Wish Message"+msg+"</b><br>");
		pw.println("<b> Present Date"+new Date()+"</b><br>");
		return null;
	}
	

}//class
