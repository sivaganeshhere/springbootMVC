package com.nit.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.nit.model.Employee;

@Component
public class Validator implements org.springframework.validation.Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(Employee.class);
	}//supports it will check wheather we are passing correct model class or not if
	//correct it will return true then validate method executed other wise return false 
	//validator method not executed.

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("Validator.validate()");
		//type casting
		Employee emp=(Employee) target;
		if(emp.getEname()==null ||emp.getEname().length()==0||emp.getEname().equals(""))
		errors.rejectValue("ename","empname.required");
		else if (emp.getEname().length()>10)
			errors.rejectValue("ename", "empname.maxlength");
		if(emp.getJob()==null ||emp.getJob().length()==0||emp.getJob().equals(""))
			errors.rejectValue("job","empdesg.required");
			else if (emp.getJob().length()>10)
				errors.rejectValue("job", "empdesg.maxlength");
		if(emp.getSal()==null ||emp.getSal().equals(""))
			errors.rejectValue("sal","empsal.required");
		else if (emp.getSal()<1 ||emp.getSal()>100000)
			errors.rejectValue("sal", "empsal.range");

	}

}
