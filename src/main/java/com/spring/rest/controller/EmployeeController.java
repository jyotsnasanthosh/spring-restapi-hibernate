package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.model.Employee;
import com.spring.rest.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value="/get", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Employee> findById(@RequestParam("id") String empId){
		return ResponseEntity.ok().body(employeeService.findById(empId));
	}
	
	@RequestMapping(value="/getEmployeeList", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<List<Employee>> findAll(){
		return ResponseEntity.ok().body(employeeService.findAll());
	}

	@RequestMapping(value="/add", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> create(@RequestBody Employee employee){
		String empId = employeeService.create(employee);
		return ResponseEntity.ok().body("Employee with "+empId+" created");
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> update(@RequestBody Employee employee){
		employeeService.update(employee);
		return ResponseEntity.ok().body("Employee with id "+employee.getEmpId()+" updated");
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> delete(@RequestParam("id") String empId){
		employeeService.delete(empId);
		return ResponseEntity.ok().body("Employee with id "+empId+" deleted");
	}
}
