package com.spring.rest.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rest.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public String create(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return employee.getEmpId();
	}

	public void update(Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.byId(Employee.class).load(employee.getEmpId());
		emp.setName(employee.getName());
		emp.setDepartment(employee.getDepartment());
		emp.setCity(employee.getCity());
		session.flush();
	}

	public void delete(String empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.byId(Employee.class).load(empId);
		if(null!=emp)
			session.delete(emp);
	}

	public List<Employee> findAll() {

		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.select(root);

		Query<Employee> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public Employee findById(String empId) {

		return sessionFactory.getCurrentSession().get(Employee.class, empId);
	}
}
