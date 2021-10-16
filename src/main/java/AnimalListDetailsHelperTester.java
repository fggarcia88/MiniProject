import java.time.LocalDate;
import java.util.List;

import control.AnimalListDetailsHelper;
import control.AnimalOwnerHelper;
import model.AnimalListDetails;
import model.AnimalOwner;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 15, 2021
 */
public class AnimalListDetailsHelperTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnimalOwner fernando = new AnimalOwner("Fernando", "Garcia");
		
		AnimalOwnerHelper aoh = new AnimalOwnerHelper();
		
		aoh.insertAnimalOwner(fernando);
		
		AnimalListDetailsHelper ald = new AnimalListDetailsHelper();
		
		AnimalListDetails fernandosList = new AnimalListDetails("Fernando's List", LocalDate.now(), fernando);

		ald.insertNewDetails(fernandosList);
		
		List<AnimalListDetails> allLists = ald.getLists();
		
		for (AnimalListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}
