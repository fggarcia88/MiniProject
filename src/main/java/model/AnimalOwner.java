package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 15, 2021
 */

@Entity
@Table(name ="owner")
public class AnimalOwner {
	
	@Id
	@GeneratedValue
	private int animalOwnerId;
	
	private String animalOwnerFirstName;
	private String animalOwnerLastName;
	
	
	public AnimalOwner() {
		super();
		
	}
	
	
	public AnimalOwner(int animalOwnerId, String animalOwnerFirstName, String animalOwnerLastName) {
		
		super();
		this.animalOwnerId = animalOwnerId;
		this.animalOwnerFirstName = animalOwnerFirstName;
		this.animalOwnerLastName = animalOwnerLastName;
		
	}
	
	
	public AnimalOwner(String animalOwnerFirstName, String animalOwnerLastName) {
		super();
		this.animalOwnerFirstName = animalOwnerFirstName;
		this.animalOwnerLastName = animalOwnerLastName;
		
	}
	
	/**
	 * @return the animalOwnerId
	 */
	public int getAnimalOwnerId() {
		return animalOwnerId;
	}
	/**
	 * @param animalOwnerId the animalOwnerId to set
	 */
	public void setAnimalOwnerId(int animalOwnerId) {
		this.animalOwnerId = animalOwnerId;
	}
	/**
	 * @return the animalOwnerFirstName
	 */
	public String getAnimalOwnerFirstName() {
		return animalOwnerFirstName;
	}
	/**
	 * @param animalOwnerFirstName the animalOwnerFirstName to set
	 */
	public void setAnimalOwnerFirstName(String animalOwnerFirstName) {
		this.animalOwnerFirstName = animalOwnerFirstName;
	}
	/**
	 * @return the animalOwnerLastName
	 */
	public String getAnimalOwnerLastName() {
		return animalOwnerLastName;
	}
	/**
	 * @param animalOwnerLastName the animalOwnerLastName to set
	 */
	public void setAnimalOwnerLastName(String animalOwnerLastName) {
		this.animalOwnerLastName = animalOwnerLastName;
	}
	
	@Override
	public String toString() {
		return "Animal Owner [id= " + animalOwnerId + " Animal Owner name= " + animalOwnerFirstName + " " + animalOwnerLastName + "]";
	}

}
