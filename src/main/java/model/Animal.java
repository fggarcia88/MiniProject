package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */

@Entity
@Table(name = "Animal Daycare")
public class Animal {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int animalId;

	private String animalType;
	private String animalBreed;
	private String animalName;
	private String animalColor;
	private String addedBy;
	
	public Animal() {
		
		super();
		
	}
	
	public Animal(String animalType, String animalBreed, String animalName, String animalColor, String addedBy) {
		
		super();
		
		this.animalType = animalType;
		this.animalBreed = animalBreed;
		this.animalName = animalName;
		this.animalColor = animalColor;
		this.addedBy = addedBy;
	
		
	}
	
	/**
	 * @return the animalBreed
	 */
	public String getAnimalBreed() {
		return animalBreed;
	}
	/**
	 * @param animalBreed the animalBreed to set
	 */
	public void setAnimalBreed(String animalBreed) {
		this.animalBreed = animalBreed;
	}
	/**
	 * @return the animalName
	 */
	public String getAnimalName() {
		return animalName;
	}
	/**
	 * @param animalName the animalName to set
	 */
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	/**
	 * @return the animalColor
	 */
	public String getAnimalColor() {
		return animalColor;
	}
	/**
	 * @param animalColor the animalColor to set
	 */
	public void setAnimalColor(String animalColor) {
		this.animalColor = animalColor;
	}
	/**
	 * @return the addedBy
	 */
	public String getaddedBy() {
		return addedBy;
	}
	/**
	 * @param addedBy the addedBy to set
	 */
	public void setaddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	/**
	 * @return the animalCheckInDate
	 */
	
	/**
	 * @param animalCheckInDate the animalCheckInDate to set
	 */
	

	/**
	 * @return the animalType
	 */
	public String getAnimalType() {
		return animalType;
	}

	/**
	 * @param animalType the animalType to set
	 */
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	/**
	 * @return the animalId
	 */
	public int getAnimalId() {
		return animalId;
	}

	/**
	 * @param animalId the animalId to set
	 */
	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	

	public String AnimalDaycareDetails() {
		
		return "Animal ID: " + this.animalId + " || " + "Animal Type: " + this.animalType + " || " + "Animal Breed: " + this.animalBreed + " || " + "Animal Name: " + this.animalName +
				" || " + "Added By: " + this.addedBy;
	}
	

}
