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
	
	public int executeCommand(String ejbql, Object... values) {
		EntityManager em  = getEntityManager();
		Query query = em.createQuery(ejbql);
		if(values != null) {
			for(int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}	
		}		
		int toReturn = query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		return toReturn;		
	}
	
	public <T> T getPurePojo(Class<T>  classToCast, String ejbql, Object... values) {
		EntityManager em = getEntityManager();
		Query query = em.createQuery(ejbql);
		if(values != null) {
			for(int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}	
		}
		T entityToReturn = (T) query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return entityToReturn;		
		
	}
	
	public <T> List<T> getPureList(Class<T>  classToCast, String ejbql, Object... values) {
		EntityManager em = getEntityManager();
		Query query = em.createQuery(ejbql);
		if(values != null) {
			for(int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}	
		}
		List<T> listToReturn =  query.getResultList();
		em.getTransaction().commit();
		em.close();
		return listToReturn;		
		
	}
	
	

	
}
