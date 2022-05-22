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
	public List<Employee> getAllEmployeeDetails() {
		return repo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
	int idVal=repo.save(emp).getEmpno();
		return "Employee Saved With the Id :: "+idVal;
	}

	@Override
	public List<Employee> getUpdatedEmployeeDetails() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployeebyId(int no) {
           Employee emp=repo.findById(no).get();
		return emp;
	}

	@Override
	public String editEmployee(Employee emp) {
		int idVal1=repo.save(emp).getEmpno();
		return idVal1+"Employee is  Updated";
	
	}

	@Override
	public String deleteEmployeebyId(int no) {
		repo.deleteById(no);
		return no+" id Employe Deleted";
	}

}//class
