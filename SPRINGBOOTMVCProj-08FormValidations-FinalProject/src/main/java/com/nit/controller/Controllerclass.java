package com.nit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.model.Employee;
import com.nit.service.IEmployeeService;
import com.nit.validations.Validator;

@Controller
public class Controllerclass {
	@Autowired
	private IEmployeeService service;
	@Autowired
	private Validator empvalidate;

	@RequestMapping("/")
	public String welcome() {
		return "home";
	}//home

	@GetMapping("/report")
	public String report(Map<String, Object>  map) {
		List<Employee> list=service.getAllEmployeeDetails();
		map.put("empdata", list);
		return "employee_report";
	}//report
	@GetMapping("/addemployee")
	public String showAddEmployee(@ModelAttribute("emp") Employee emp) {
		emp.setJob("Clerk");
		return "add_employee";
	}//editEmployee
	/*@PostMapping("/addemployee")
	public String addEmployee(Map<String,Object> map,
			@ModelAttribute("emp") Employee emp) {
		String result=service.registerEmployee(emp);
		List<Employee> list=service.getUpdatedEmployeeDetails();
		map.put("resultMsg", result);
		//map.put("empdata", list);//prgimplementation
		//return "employee_report";//prgimplementation
		return "redirect:report";
	}*/
	/*//Redirect scope to display msg
	@PostMapping("/addemployee")
	public String addEmployee(RedirectAttributes attribute,
			@ModelAttribute("emp") Employee emp) {
		String result=service.registerEmployee(emp);
		List<Employee> list=service.getUpdatedEmployeeDetails();
		attribute.addFlashAttribute("resultMsg",result);
		return "redirect:report";
	}*/
	//Using Redirect scope to display msg only once it displayed after refresh it will went 
	//so use Session scope which is one per webserver
	
	@PostMapping("/addemployee")
	public String addEmployee(HttpSession ses,
			@ModelAttribute("emp") Employee emp,BindingResult errors) {
		System.out.println("Controllerclass.addEmployee()");
		if(emp.getVflag().equalsIgnoreCase("no")) {
		//business logic errors type mismatch errors
		if(errors.hasFieldErrors()) {
			return "add_employee";
		}
		
		if(empvalidate.supports(emp.getClass())) {
			empvalidate.validate(emp,errors);
			if(errors.hasErrors())
				return "add_employee";
		}
	}
		//applicaion logic errors errors
		if(emp.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job","job.reject");
			return "add_employee";
		}
		String result=service.registerEmployee(emp);
		List<Employee> list=service.getUpdatedEmployeeDetails();
				ses.setAttribute("resultMsg",result);
		return "redirect:report";
	}

	@GetMapping("/edit")
	public String editEmployee(@RequestParam("no") int no,
			@ModelAttribute("emp") Employee emp) {
		Employee emp1=service.getEmployeebyId(no);
		//emp=emp1;
		BeanUtils.copyProperties(emp1, emp);
		return "edit_employee";
	}
	/*@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
		String result=service.editEmployee(emp);
		List<Employee> list=service.getUpdatedEmployeeDetails();
		map.put("resultMsg", result);
		//map.put("empdata", list);//prgimplementation
				//return "employee_report";//prgimplementation
				return "redirect:report";

	}*/
	//Using Redirect scope to display msg only once it displayed after refresh it will went 
		//so use Session scope which is one per webserver
	/*@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attributes) {
		String result=service.editEmployee(emp);
		List<Employee> list=service.getUpdatedEmployeeDetails();
		attributes.addFlashAttribute("resultMsg", result);
		
				return "redirect:report";

	}*/
	@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp,
																						HttpSession ses,
																							BindingResult errors) {
		System.out.println("Controllerclass.editEmployee()");
		if(emp.getVflag().equalsIgnoreCase("no")) {
		//business logic errors type mismatch errors
		if(errors.hasFieldErrors())
			return "edit_employee";
		
		if(empvalidate.supports(emp.getClass())) {
			empvalidate.validate(emp, errors);
			if(errors.hasErrors())
				return "edit_employee";
		}
	}
		//applicaion logic errors errors
				if(emp.getJob().equalsIgnoreCase("hacker")) {
					errors.rejectValue("job","job.reject");
					return "edit_employee";
				}
		String result=service.editEmployee(emp);
		List<Employee> list=service.getUpdatedEmployeeDetails();
		ses.setAttribute("resultMsg", result);
				return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no,HttpSession ses)
	{
		String result1=service.deleteEmployeebyId(no);
		List<Employee> list=service.getUpdatedEmployeeDetails();
		ses.setAttribute("resultMsg", result1);
	return "redirect:report";
	}

}//class
