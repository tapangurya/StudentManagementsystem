package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Admin;


public class AdminDao {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction et =  em.getTransaction();

	public Admin saveAdmin(Admin adm) {
		et.begin();
		Admin admin = em.merge(adm);
		et.commit();
		return admin;
		
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

	
	public boolean updateProfilePhoto(String email, String photoPath) {
	    try {
	        // Begin transaction
	        et.begin();

	        // Fetch the admin by email
	        Query q = em.createQuery("select a from Admin a where a.email = :email");
	        q.setParameter("email", email);

	        List<Admin> list = q.getResultList();

	        // If the admin exists, update the profile photo path
	        if (!list.isEmpty()) {
	            Admin admin = list.get(0);
	            admin.setProfilePhotoPath(photoPath); // Assuming `Admin` has a setter for `profilePhotoPath`
	            em.merge(admin);
	        } else {
	            // Admin with the specified email not found
	            return false;
	        }

	        // Commit the transaction
	        et.commit();
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();

	        // Rollback the transaction in case of an error
	        if (et.isActive()) {
	            et.rollback();
	        }
	        return false;
	    }
	}



	
   
}
