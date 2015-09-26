package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Actor {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private String firstName;
	private String lastName;

	
	public Actor() {
		super();
	}
	public Actor( String firstName, String lastName) {
		super();
		
		setFirstName(firstName);
		setLastName(lastName);
	}
	public Actor(int id, String firstName, String lastName) {
		super();
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}
