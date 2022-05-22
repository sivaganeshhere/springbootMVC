package com.nit.service;

import java.util.List;

import com.nit.model.Employee;

public interface IEmployeeService {
public List<Employee> getAllEmployee();
public String registerEmployee(Employee emp);
public String editEmployee(Employee emp);
public Employee getEmployeeById(int no);
public String  deleteEmployeeById(int no);
}
