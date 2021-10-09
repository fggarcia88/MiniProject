package model;

import java.time.LocalDateTime;

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
	@Column(name = "Animal Checkin ID")
	private int animalId;

	private String animalType;
	private String animalBreed;
	private String animalName;
	private String animalColor;
	private String animalOwnerName;
	private LocalDateTime animalCheckInDateTime;
	
	public Animal() {
		super();
	}
	
	public Animal(int animalId, String animalType, String animalBreed, String animalName, String animalColor, String animalOwnerName, LocalDateTime animalCheckInDateTime) {
		super();
		
		this.animalId = animalId;
		this.animalType = animalType;
		this.animalBreed = animalBreed;
		this.animalName = animalName;
		this.animalColor = animalColor;
		this.animalOwnerName = animalOwnerName;
		this.animalCheckInDateTime = animalCheckInDateTime;
		
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
	 * @return the animalOwnerName
	 */
	public String getAnimalOwnerName() {
		return animalOwnerName;
	}
	/**
	 * @param animalOwnerName the animalOwnerName to set
	 */
	public void setAnimalOwnerName(String animalOwnerName) {
		this.animalOwnerName = animalOwnerName;
	}
	/**
	 * @return the animalCheckInDate
	 */
	public LocalDateTime getAnimalCheckInDateTime() {
		return animalCheckInDateTime;
	}
	/**
	 * @param animalCheckInDate the animalCheckInDate to set
	 */
	public void setAnimalCheckInDateTime(LocalDateTime animalCheckInDate) {
		this.animalCheckInDateTime = animalCheckInDate;
	}

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
				" || " + "Animal Owner's Name: " + this.animalOwnerName + " || " + "Check In Date/Time: " + this.animalCheckInDateTime;
	}
	

}
