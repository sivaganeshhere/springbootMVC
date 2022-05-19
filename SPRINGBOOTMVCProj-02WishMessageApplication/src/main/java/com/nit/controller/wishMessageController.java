package com.nit.controller;

import java.util.Date;

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
	@RequestMapping("/wish")
	public ModelAndView fetchMessage() {
		String msg=service.wishMessage();
		ModelAndView mav=new ModelAndView();
		mav.addObject("wMsg",msg);
		mav.addObject("sysDate",new Date());
		mav.setViewName("show_result");
		return mav;
	}
	

}//class