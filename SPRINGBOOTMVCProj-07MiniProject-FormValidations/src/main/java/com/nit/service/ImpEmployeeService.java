package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.Employee;
import com.nit.repo.IEmployeeRepo;

@Service
public class ImpEmployeeService implements IEmployeeService{

	@Autowired
	private IEmployeeRepo repo;
	
	@Override
	public List<Employee> getAllEmployee() {
		return  repo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
	int idVal=repo.save(emp).getEmpno();
		return "Employee is saved with the id value"+idVal;
	}

	@Override
	public String editEmployee(Employee emp) {
		int idVal=repo.save(emp).getEmpno();
		return "Employee Updated"+idVal;
	}

	@Override
	public Employee getEmployeeById(int no) {
		Employee emp=repo.findById(no).get();
		return emp;
	}

	@Override
	public String deleteEmployeeById(int no) {
		repo.deleteById(no);
		return no+" Emp no employee is  deleted";
	}

}//class
