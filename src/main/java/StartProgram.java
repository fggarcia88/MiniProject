

import java.util.List;
import java.util.Scanner;

import control.AnimalHelper;
import model.Animal;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static AnimalHelper ah = new AnimalHelper();

		private static void addAnAnimal() {
			
			// TODO Auto-generated method stub
			
			System.out.print("Enter the type of animal that's checking in: ");
			String animalType = in.nextLine();
			System.out.print("Enter the breed of the animal that's checking in: ");
			String animalBreed = in.nextLine();
			System.out.print("Enter the name of the animal that's checking in: ");
			String animalName = in.nextLine();
			System.out.print("Enter the color of the animal: ");
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

			
			Animal toDelete = new Animal(animalType, animalBreed, animalName, animalColor, animalOwnerName);
			ah.deleteAnimal(toDelete);
		}

		private static void editAnAnimal() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Store");
			System.out.println("2 : Search by Item");
			int searchBy = in.nextInt();
			in.nextLine();
			
			
			List<Animal> foundAnimal;
			if (searchBy == 1) {
				System.out.print("Enter the type of animal you're looking for: ");
				String animalType = in.nextLine();
				foundAnimal = ah.searchForAnimalByType(animalType);
			}
			else if (searchBy == 2) {
				
				System.out.print("Enter the breed of the animal you're looking for: ");
				String animalBreed = in.nextLine();
				foundAnimal = ah.searchForAnimalByBreed(animalBreed);
			}
			
			else if (searchBy == 3) {
				
				System.out.print("Enter the name of the animal you're looking for: ");
				String animalName = in.nextLine();
				foundAnimal = ah.searchForAnimalByName(animalName);
			}
			
			else if (searchBy == 4) {
				System.out.print("Enter the color of the animal you're looking for: ");
				String animalColor = in.nextLine();
				foundAnimal = ah.searchForAnimalByColor(animalColor);
			}
				
			 else {
				 
				System.out.print("Enter the name of the animal's owner you're looking for: ");
				String animalOwnerName = in.nextLine();
				foundAnimal = ah.searchForAnimalByOwnerName(animalOwnerName);
				
			}

			if (!foundAnimal.isEmpty()) {
				System.out.println("Found Results.");
				for (Animal l : foundAnimal) {
					System.out.println(l.getAnimalId() + " : " + l.toString());
				}
		
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Animal toEdit = ah.searchForAnimalByAnimalId(idToEdit);
				System.out.println("Retrieved " + toEdit.getAnimalName() + " from " + toEdit.getAnimalOwnerName());
				

				System.out.println("1 : Update the animal's type");
				System.out.println("2 : Update the animal's breed");
				System.out.println("3 : Updated the animal's name");
				System.out.println("4 : Update the animal's color");
				System.out.println("5 : Update the animal's owner's name");
				
				
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("Updated animal type: ");
					String newAnimalType = in.nextLine();
					toEdit.setAnimalType(newAnimalType);
				} else if (update == 2) {
					System.out.print("Updated animal breed: ");
					String newAnimalBreed = in.nextLine();
					toEdit.setAnimalBreed(newAnimalBreed);
				}
				else if (update == 3) {
					System.out.println("Updated animal name: ");
					String newAnimalName = in.nextLine();
					toEdit.setAnimalName(newAnimalName);
				}
				else if (update == 4) {
					System.out.println("Updated animal color: ");
					String newAnimalColor = in.nextLine();
					toEdit.setAnimalColor(newAnimalColor);
					
				}
				else if (update == 5) {
					System.out.println("Updated animal owner's name: ");
					String newAnimalOwnerName = in.nextLine();
					toEdit.setAnimalOwnerName(newAnimalOwnerName);
					
				}

				ah.updateAnimal(toEdit);

			} else {
				System.out.println("---- No results found for your query");
			}

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
					ah.cleanUp();
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
