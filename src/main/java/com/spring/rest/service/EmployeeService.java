package com.spring.rest.service;

import java.util.List;

import com.spring.rest.model.Employee;

public interface EmployeeService {

	public String create(Employee employee);
	public void update(Employee employee);
	public void delete(String empId);
	public List<Employee> findAll();
	public Employee findById(String empId);
}
