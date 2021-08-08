package br.com.completestruts2.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.completestruts2.entitys.JPAUtil;

public abstract class JPABasicDAO<T> {
	
	public <T> T save(T objTosave) {
		EntityManager em =  JPAUtil.getInstance().getEntityManager();
		em.persist(objTosave);
		em.getTransaction().commit();
		em.close();
		return objTosave;
		
	}
	
	public void remove(Class<T> objToRemove, Serializable key) {
		EntityManager em =  JPAUtil.getInstance().getEntityManager();
		T obj = em.find(objToRemove, key);
		if(obj != null) {
			em.refresh(obj);
		}
		em.getTransaction().commit();
		em.close();		
		
	}
	
	public void update(Class<T> objToUpdate) {
		EntityManager em =  JPAUtil.getInstance().getEntityManager();
		em.merge(objToUpdate);		
		em.getTransaction().commit();
		em.close();		
		
	}
	
	public T reflesh(T objToRefresh) {
		EntityManager em =  JPAUtil.getInstance().getEntityManager();
		em.refresh(objToRefresh);
		em.getTransaction().commit();
		em.close();		
		return objToRefresh;
	}
	
	public <T> T findByPrimaryKey(Class<T> objToCast, Serializable key) {
		EntityManager em =  JPAUtil.getInstance().getEntityManager();
		T obj = em.find(objToCast, key);		
		em.getTransaction().commit();
		em.close();		
		return obj;
	}
	
	public int executeCommand(String ejbql, Object... values) {
		EntityManager em  = JPAUtil.getInstance().getEntityManager();
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
		EntityManager em = JPAUtil.getInstance().getEntityManager();
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
		EntityManager em = JPAUtil.getInstance().getEntityManager();
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
