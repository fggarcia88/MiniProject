package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

}
