package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Genre {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String genre;
	
	
	public Genre() {
		super();
	}
	public Genre(String genre) {	
		
		setGenre(genre);
	}
	public Genre(int id, String genre) {
		super();
		setId(id);
		setGenre(genre);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
