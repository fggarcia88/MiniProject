package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Animal;
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
	
	/**
	 * @param idToEdit
	 * @return
	 */
 	public AnimalOwner searchForAnimalByAnimalId(int animalOwnerId) {
 		EntityManager em = emfactory.createEntityManager();
 		em.getTransaction().begin();
 		AnimalOwner foundAnimalOwnerId = em.find(AnimalOwner.class, animalOwnerId);
 		em.close();
 		return foundAnimalOwnerId;
	}
 	
	/**
	 * @param toEdit
	 */	
	public void updateAnimal(AnimalOwner toUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();		
	}
	
	public AnimalOwner findOwner(String firstNameToLookUp, String lastNameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AnimalOwner> typedQuery = em.createQuery("select ao from AnimalOwner ao where "
				+ "ao.animalOwnerFirstName = :selectedFirstName and ao.animalOwnerLastName = :selectedLastName", AnimalOwner.class);
		typedQuery.setParameter("selectedFirstName", firstNameToLookUp);
		typedQuery.setParameter("selectedLastName", lastNameToLookUp);
		typedQuery.setMaxResults(1);
		AnimalOwner foundAnimalOwner;
		try	{
			foundAnimalOwner = typedQuery.getSingleResult();
		} catch	(NoResultException ex) {
			foundAnimalOwner = new AnimalOwner(firstNameToLookUp, lastNameToLookUp);
		}
		em.close();
		return foundAnimalOwner;
	}

}
