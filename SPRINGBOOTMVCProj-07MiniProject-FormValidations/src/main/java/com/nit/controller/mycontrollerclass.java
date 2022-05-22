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
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.model.Employee;
import com.nit.service.IEmployeeService;
import com.nit.validations.EmployeeValidator;

@Controller
public class mycontrollerclass {
@Autowired
	private IEmployeeService service;
@Autowired
private EmployeeValidator empval;
	
	@GetMapping("/")
	public String welcomePage() {
		return "welcome";
	}
	@GetMapping("/report")
	public String reportGeneration(Map<String, Object> map) {
		List<Employee> list=service.getAllEmployee();
		map.put("empData", list);
		return "emp_report";
	}
	@GetMapping("/add")
	public String addEmployee(@ModelAttribute("emp") Employee emp) {
		emp.setJob("worker");
		return "employee_register";
	}
	@PostMapping("/add")
	public String registerEmployee(HttpSession ses,Map<String,Object> map,
			                                               @ModelAttribute("emp") Employee emp,
			                                               BindingResult errors) {
		if(emp.getVflag().equalsIgnoreCase("no")) {
		if(empval.supports(emp.getClass())) {
			empval.validate(emp, errors);
			if(errors.hasErrors())
				return "employee_register";
		}}
		String result=service.registerEmployee(emp);
		ses.setAttribute("resultMsg", result);
		return "redirect:report";
	}
	@GetMapping("/edit")
	public String detailsOfEmployee(@ModelAttribute("emp") Employee emp,
													@RequestParam("no") Integer no) {
		//getting employee details  dynamically from database
		Employee emp1=service.getEmployeeById(no);
		BeanUtils.copyProperties(emp1,emp);                                         
		return "employee_edit";
	}
	@PostMapping("/edit")
	public String editEmployeeDetails(@ModelAttribute("emp") Employee emp,
																	Map<String,Object> map,
																	BindingResult errors) {
		if(emp.getVflag().equalsIgnoreCase("no")) {
		if(empval.supports(emp.getClass())) {
			empval.validate(emp, errors);
			if(errors.hasErrors())
				return "employee_edit";
		}}
		String msg=service.editEmployee(emp);
		List<Employee> list=service.getAllEmployee();
		
		map.put("empData", list);	
		return "emp_report";
	}
	@GetMapping("/delete")
	public String deleteEmployeeDetails(@RequestParam("no") int no,
																	Map<String,Object> map) {
		String msg=service.deleteEmployeeById(no);
		List<Employee> list=service.getAllEmployee();
		map.put("resultMsg", msg);
		map.put("empData", list);	
		return "emp_report";
	}
	
}//class
