package control;

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
			TypedQuery<Animal>typedQuery = em.createQuery("select ai from Animal where ai.animalType = :selectedAnimalType and ai.animalBreed = :selectedAnimalBreed and ai.animalName = :selectedAnimalName"
					+ "and ai.animalColor = :selectedAnimalColor and ai.animalOwnerName = :selectedAnimalOwnerName", Animal.class);
			
			typedQuery.setParameter("selectedAnimalType", toDelete.getAnimalType());
			typedQuery.setParameter("selectedAnimaBreed", toDelete.getAnimalBreed());
			typedQuery.setParameter("selectedAnimalName", toDelete.getAnimalName());
			typedQuery.setParameter("selectedAnimalColor", toDelete.getAnimalColor());
			typedQuery.setParameter("selectedAnimalOwnerName", toDelete.getAnimalOwnerName());
			
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
		
		
		return null;
	}

	/**
	 * @param animalBreed
	 * @return
	 */
	public List<Animal> searchForAnimalByBreed(String animalBreed) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param animalName
	 * @return
	 */
	public List<Animal> searchForAnimalByName(String animalName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param animalColor
	 * @return
	 */
	public List<Animal> searchForAnimalByColor(String animalColor) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param animalOwnerName
	 * @return
	 */
	public List<Animal> searchForAnimalByOwnerName(String animalOwnerName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public Animal searchForAnimalByAnimalId(int idToEdit) {
		// TODO Auto-generated method stub
		return null;
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

}
