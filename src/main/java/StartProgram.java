
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import control.AnimalHelper;
import model.Animal;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static AnimalHelper ah = new AnimalHelper();

		private static void addAnAnimal() {
			
			// TODO Auto-generated method stub
			
			System.out.print("Enter a store: ");
			String animalType = in.nextLine();
			System.out.print("Enter an item: ");
			String animalBreed = in.nextLine();
			System.out.print("Enter an item: ");
			String animalName = in.nextLine();
			System.out.print("Enter an item: ");
			String animalColor = in.nextLine();
			System.out.print("Enter the owners name: ");
			String animalOwnerName = in.nextLine();
		

			Animal toAdd = new Animal(animalType, animalBreed, animalName, animalColor, animalOwnerName);
			ah.insertAnimal(toAdd);
			
		}

		private static void deleteAnAnimal() {
			
			// TODO Auto-generated method stub
			System.out.print("Enter the type of animal to delete: ");
			String animalType = in.nextLine();
			System.out.print("Enter the animal breed to delete: ");
			String animalBreed = in.nextLine();
			System.out.print("Enter the animal's name to delete: ");
			String animalName = in.nextLine();
			System.out.print("Enter the color of the animal to delete: ");
			String animalColor = in.nextLine();
			System.out.print("Enter the owner's name of the animal to delete: ");
			String animalOwnerName = in.nextLine();

			

		}

		private static void editAnAnimal() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Store");
			System.out.println("2 : Search by Item");
			int searchBy = in.nextInt();
			in.nextLine();
			
			
			/*List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the store name: ");
				String storeName = in.nextLine();
				
			} else {
				System.out.print("Enter the item: ");
				String itemName = in.nextLine();
				

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getItem() + " from " + toEdit.getStore());
				System.out.println("1 : Update Store");
				System.out.println("2 : Update Item");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Store: ");
					String newStore = in.nextLine();
					toEdit.setStore(newStore);
				} else if (update == 2) {
					System.out.print("New Item: ");
					String newItem = in.nextLine();
					toEdit.setItem(newItem);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}
*/
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an animal to check in");
				System.out.println("*  2 -- Edit an animal");
				System.out.println("*  3 -- Delete an animal");
				System.out.println("*  4 -- View the list of animal's that are checked in");
				System.out.println("*  5 -- Exit the Animal Daycare Check-In program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnAnimal();
				} else if (selection == 2) {
					editAnAnimal();
				} else if (selection == 3) {
					deleteAnAnimal();
				} else if (selection == 4) {
					viewTheList();
				} else {
					//lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			
			List<Animal>allAnimals = ah.showAllAnimals();
			
			for(Animal singleAnimal : allAnimals) {
				System.out.println(singleAnimal.AnimalDaycareDetails());
			}
		}

	}
