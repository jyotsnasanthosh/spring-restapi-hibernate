package com.spring.rest.dao;

import java.util.List;

import com.spring.rest.model.Employee;

public interface EmployeeDao {

	public String create(Employee employee);
	public void update(Employee employee);
	public void delete(String empId);
	public List<Employee> findAll();
	public Employee findById(String empId);
}
