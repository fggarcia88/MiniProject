import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import control.AnimalListDetailsHelper;
import control.AnimalOwnerHelper;
import model.Animal;
import model.AnimalListDetails;
import model.AnimalOwner;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 15, 2021
 */
public class AnimalOwnerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnimalOwner Cody = new AnimalOwner("Cody", "Hale");
		
		AnimalListDetailsHelper aldh = new AnimalListDetailsHelper();
		
		Animal dog = new Animal("dog", "poodle", "noodles", "cream", "Cody");
		
		List<Animal>codysAnimals = new ArrayList<Animal>();
		codysAnimals.add(dog);
		
		AnimalListDetails codysList = new AnimalListDetails("Cody's List", LocalDate.now(), Cody);
		codysList.setListOfAnimals(codysAnimals);
		
		aldh.insertNewDetails(codysList);
		
		List<AnimalListDetails> allAnimals = aldh.getLists();
		
		for (AnimalListDetails animalListDetails : allAnimals) {
			System.out.println(animalListDetails.toString());
			
		}

	}

}
