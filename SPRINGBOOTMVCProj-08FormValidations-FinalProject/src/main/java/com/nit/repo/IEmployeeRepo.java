package com.nit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
}
