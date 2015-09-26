package model;

import java.security.Permission;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table
public class Movie {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String title;
	@ManyToMany(targetEntity=Actor.class, cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.REMOVE})
	private Set<Permission> permissions = new HashSet<Permission>();
	private List<Actor> actor;
	@OneToMany (targetEntity = Genre.class)
	private List<Genre> genre;

	public Movie() {
		super();
	}
	


	public Movie(String title, List<Actor> actor, List<Genre> genre) {
		setTitle(title);
		setActor(actor);
		setGenre(genre);
	}
	public Movie(int id, String title, List<Actor> actor, List<Genre> genre) {
		super();
		setId(id);
		setTitle(title);
		setActor(actor);
		setGenre(genre);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Actor> getActor() {
		return actor;
	}
	public void setActor(List<Actor> actor) {
		this.actor = actor;
	}
	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", actor=" + actor + ", genre=" + genre + "]";
	}
	
	
}
