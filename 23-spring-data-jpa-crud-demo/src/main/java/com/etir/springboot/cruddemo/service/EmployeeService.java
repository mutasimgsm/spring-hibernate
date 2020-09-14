package com.etir.springboot.cruddemo.service;

import java.util.List;

import com.etir.springboot.cruddemo.entity.Employee;

public interface EmployeeService {


	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void deleteById(int theId);
	
	public void save(Employee employee);
	
}
