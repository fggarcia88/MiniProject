package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 15, 2021
 */

@Entity
public class AnimalListDetails {
	@Id
	@GeneratedValue
	private int id;
	
	private String listName;
	private LocalDate listDate;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private AnimalOwner owner;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Animal> listOfAnimals;
	
	
	public AnimalListDetails() {
		
		super();
	}
	
	
	public AnimalListDetails(int id, String listName, LocalDate listDate, AnimalOwner owner, List<Animal> listOfAnimals) {
		super();
		
		this.id = id;
		this.listName = listName;
		this.listDate = listDate;
		this.owner = owner;
		this.listOfAnimals = listOfAnimals;
	}
	
	public AnimalListDetails(String listName, LocalDate listDate, AnimalOwner owner, List<Animal> listOfAnimals) {
		super();
		
		this.listName = listName;
		this.listDate = listDate;
		this.owner = owner;
		this.listOfAnimals = listOfAnimals;
		
	}
	
	
	public AnimalListDetails(String listName, LocalDate listDate, AnimalOwner owner) {
		super();
		
		this.listName = listName;
		this.listDate = listDate;
		this.owner = owner;
		
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}
	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	/**
	 * @return the listDate
	 */
	public LocalDate getListDate() {
		return listDate;
	}
	/**
	 * @param listDate the listDate to set
	 */
	public void setListDate(LocalDate listDate) {
		this.listDate = listDate;
	}
	/**
	 * @return the owner
	 */
	public AnimalOwner getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(AnimalOwner owner) {
		this.owner = owner;
	}
	/**
	 * @return the listOfAnimals
	 */
	public List<Animal> getListOfAnimals() {
		return listOfAnimals;
	}
	/**
	 * @param listOfAnimals the listOfAnimals to set
	 */
	public void setListOfAnimals(List<Animal> listOfAnimals) {
		this.listOfAnimals = listOfAnimals;
	}
	
	
	

}
