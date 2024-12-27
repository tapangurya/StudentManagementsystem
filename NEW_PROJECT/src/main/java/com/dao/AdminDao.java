package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Admin;

public class AdminDao {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public Admin saveAdmin(Admin admin) {
		et.begin();
		Admin ad = em.merge(admin);
		et.commit();
		return ad;
		
	}
	
	public Admin findBYName(String adminName) {
		
		return em.find(Admin.class, adminName);
		
	}
public Admin findByEmail(String email) {
		
		// custom query
				Query q = em.createQuery("select a from Admin a where email=?1");

				q.setParameter(1, email);

				List<Admin> list = q.getResultList();
				if (!list.isEmpty())
					return list.get(0);

				return null;
	}

public Admin findByEId(int id) {
	
	return em.find(Admin.class, id);

}
	

}
