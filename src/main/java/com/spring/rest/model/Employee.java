package com.spring.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@Column(name="empid")
	private String empId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="department")
	private String department;
	
	@Column(name="city")
	private String city;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", department="
				+ department + ", city=" + city + "]";
	}
}
	
