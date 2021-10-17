package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AnimalListDetails;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 15, 2021
 */
public class AnimalListDetailsHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject");
	
	public void insertNewDetails(AnimalListDetails ald) {
		
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ald);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<AnimalListDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<AnimalListDetails> allDetails = em.createQuery("SELECT ad from AnimalListDetails ad").getResultList();
		return allDetails;
	}
	
	public AnimalListDetails searchForListDetailsById(Integer tempId) { 
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AnimalListDetails found = em.find(AnimalListDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void	updateList(AnimalListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void	deleteList(AnimalListDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AnimalListDetails> typedQuery = em.createQuery("select ald from AnimalListDetails ald where ald.id = :selectedId", AnimalListDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		AnimalListDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

}
