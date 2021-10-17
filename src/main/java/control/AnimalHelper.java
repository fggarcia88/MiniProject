package control;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Animal;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 12, 2021
 */
public class AnimalHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject");
	
public void insertAnimal(Animal a) {
	
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(a);
	em.getTransaction().commit();
	em.close();
	
	}

	public List<Animal> showAllAnimals(){
	
	EntityManager em = emfactory.createEntityManager();
	
	@SuppressWarnings("unchecked")
	List<Animal>allAnimals = em.createQuery("SELECT a FROM Animal a").getResultList();
	
	return allAnimals;

	}
	
	public void deleteAnimal(Animal toDelete) {
		
		try {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Animal>typedQuery = em.createQuery("select an from Animal an where an.animalType = :selectedAnimalType "
					+ "and an.animalBreed = :selectedAnimalBreed and an.animalName = :selectedAnimalName "
					+ "and an.animalColor = :selectedAnimalColor and an.addedBy = :selectedaddedBy", Animal.class);
			
			typedQuery.setParameter("selectedAnimalType", toDelete.getAnimalType());
			typedQuery.setParameter("selectedAnimalBreed", toDelete.getAnimalBreed());
			typedQuery.setParameter("selectedAnimalName", toDelete.getAnimalName());
			typedQuery.setParameter("selectedAnimalColor", toDelete.getAnimalColor());
			typedQuery.setParameter("selectedaddedBy", toDelete.getaddedBy());
			
			typedQuery.setMaxResults(1);
			Animal result = typedQuery.getSingleResult();
			em.remove(result);
			em.getTransaction().commit();
			em.close();	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("The information entered did not find any results or was invalid. Try again!");
		}
		
		
	}

	/**
	 * @param animalType
	 * @return
	 */
	public List<Animal> searchForAnimalByType(String animalType) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animal>typedQuery = em.createQuery("Select ei FROM Animal ei where ei.animalType = :selectedAnimalType", Animal.class);
		typedQuery.setParameter("selectedAnimalType", animalType);
		List<Animal>foundAnimalName = typedQuery.getResultList();
		em.close();
		
		return foundAnimalName;
		
	
	}

	/**
	 * @param animalBreed
	 * @return
	 */
	public List<Animal> searchForAnimalByBreed(String animalBreed) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animal>typedQuery = em.createQuery("Select ei FROM Animal ei where ei.animalBreed = :selectedAnimalBreed", Animal.class);
		typedQuery.setParameter("selectedAnimalBreed", animalBreed);
		List<Animal>foundAnimalBreed = typedQuery.getResultList();
		em.close();
		
		return foundAnimalBreed;
	}

	/**
	 * @param animalName
	 * @return
	 */
	public List<Animal> searchForAnimalByName(String animalName) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animal>typedQuery = em.createQuery("Select ei FROM Animal ei where ei.animalName = :selectedAnimalName", Animal.class);
		typedQuery.setParameter("selectedAnimalName", animalName);
		List<Animal>foundAnimalName = typedQuery.getResultList();
		em.close();
		
		return foundAnimalName;
	}

	/**
	 * @param animalColor
	 * @return
	 */
	public List<Animal> searchForAnimalByColor(String animalColor) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animal>typedQuery = em.createQuery("Select ei FROM Animal ei where ei.animalColor = :selectedAnimalColor", Animal.class);
		typedQuery.setParameter("selectedAnimalColor", animalColor);
		List<Animal>foundAnimalColor = typedQuery.getResultList();
		em.close();
		
		return foundAnimalColor;
	}

	/**
	 * @param addedBy
	 * @return
	 */
	public List<Animal> searchForAnimalByOwnerName(String addedBy) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animal>typedQuery = em.createQuery("Select ei FROM Animal ei where ei.addedBy = :selectedaddedBy", Animal.class);
		typedQuery.setParameter("selectedaddedBy", addedBy);
		List<Animal>foundaddedBy = typedQuery.getResultList();
		em.close();
		
		return foundaddedBy;
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	 	public Animal searchForAnimalByAnimalId(int animalId) {
		// TODO Auto-generated method stub
	 		
	 		EntityManager em = emfactory.createEntityManager();
	 		em.getTransaction().begin();
	 		Animal foundAnimalId = em.find(Animal.class, animalId);
	 		em.close();
	 		return foundAnimalId;
	} 

	/**
	 * @param toEdit
	 */	
	public void updateAnimal(Animal toUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();		
	}
	
	public void cleanUp() {
		
		emfactory.close();
		
	}

}
