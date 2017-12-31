package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.dao.EmployeeDao;
import com.spring.rest.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public String create(Employee employee) {
		return employeeDao.create(employee);
	}
	
	public void update(Employee employee) {
		employeeDao.update(employee);
	}
	
	public void delete(String empId) {
		employeeDao.delete(empId);
	}
	
	public List<Employee> findAll() {
		List<Employee> employeeList = employeeDao.findAll();
		return employeeList;
	}
	
	public Employee findById(String empId) {
		Employee employee = employeeDao.findById(empId);
		return employee;
	}
}

