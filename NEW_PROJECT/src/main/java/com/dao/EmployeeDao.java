package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.dto.Admin;
import com.dto.Employee;

public class EmployeeDao {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public Employee createEmployee(Employee emp) {
		et.begin();
		Employee emp1 = em.merge(emp);
		et.commit();
		return emp1;
	}
	public Employee findByEId(int id) {
		
		return em.find(Employee.class, id);

	}
	public void deleteEmployee(Employee employee) {
		et.begin();
		em.remove(employee);
		et.commit();
		
	}
}
