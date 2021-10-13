package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Animal;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 12, 2021
 */
public class AnimalHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Animal Check-In");
	
public void insertAnimal(Animal a) {
	
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction();
	em.persist(a);
	em.getTransaction().commit();
	em.close();
	
	}

	public List<Animal> showAllAnimals(){
	
	EntityManager em = emfactory.createEntityManager();
	
	@SuppressWarnings("unchecked")
	List<Animal>allAnimals = em.createQuery("SELECT i FROM Animal i").getSingleResult();
	
	return allAnimals;

	}
}
