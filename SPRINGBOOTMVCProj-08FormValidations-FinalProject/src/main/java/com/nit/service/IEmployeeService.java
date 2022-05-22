package com.nit.service;

import java.util.List;

import com.nit.model.Employee;

public interface IEmployeeService {
public List<Employee> getAllEmployeeDetails();
public String registerEmployee(Employee emp);
public List<Employee> getUpdatedEmployeeDetails();
public Employee getEmployeebyId(int no);
public String editEmployee(Employee emp);
public String deleteEmployeebyId(int no);
}//class
