package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AnimalOwner;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 15, 2021
 */
public class AnimalOwnerHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject");
	
	public void insertAnimalOwner(AnimalOwner ao) {
		
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ao);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<AnimalOwner> showAllAnimalOwners(){
		
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<AnimalOwner> allAnimalOwners = em.createQuery("Select o FROM AnimalOwner o").getResultList();
		
		return allAnimalOwners;
	}

}
