package br.com.completestruts2.entitys;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class JPAUtil {
	
	
	private static JPAUtil me;
	private EntityManagerFactory emf;
	
	private JPAUtil() {
		createConnection();
	}

	private void createConnection() {		
		emf = Persistence.createEntityManagerFactory("MyCompleteStruts2AppPU");		
	}

	public static JPAUtil getInstance() {
		if(me == null) {
			me = new JPAUtil(); 
		}
		return me;
	}
	
	public EntityManager getEntityManager() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		return em;
	}	

	
}
