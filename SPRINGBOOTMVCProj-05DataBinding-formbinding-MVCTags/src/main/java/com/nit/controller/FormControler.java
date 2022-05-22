package com.nit.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.model.Student;

@Controller
public class FormControler {
	@GetMapping("/")
  public String welcomePage() {
	  return "welcome";
	  }
	@GetMapping("/register")
	public String showRegister(@ModelAttribute("stud") Student st) {
		return "student_register";
	}
	@PostMapping("/register")
	public String registerStudent(Map<String, Object> map,
														@ModelAttribute Student st) {
		
		System.out.println(st);
		return "show_result";
	}
	
}//class
