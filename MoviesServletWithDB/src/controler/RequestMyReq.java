package controler;

import java.security.Permission;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Movie;
import model.Actor;
import model.Genre;

public class RequestMyReq {

	public static void insertMovie(String title, List<Actor> actors, List<Genre> genre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesServletWithDB");
		EntityManager em = emf.createEntityManager();
		Movie movie = new Movie(title, actors, genre);
		em.getTransaction().begin();
		em.merge(movie);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void insertGenre(String genre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesServletWithDB");
		EntityManager em = emf.createEntityManager();
		Genre genre1 = new Genre(genre);
		em.getTransaction().begin();
		em.persist(genre1);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void insertActor(String firstNameAuthor, String lastName) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesServletWithDB");
		EntityManager em = emf.createEntityManager();
		Actor actor = new Actor(firstNameAuthor, lastName);
		em.getTransaction().begin();
		em.persist(actor);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static List<Actor> showActors() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesServletWithDB");
		EntityManager em = emf.createEntityManager();
		List<Actor> actors = null;
		Query query = null;
		em.getTransaction().begin();
		query = em.createQuery("select a from Actor a");
		actors = query.getResultList();
		em.close();
		emf.close();
		return actors;
	}

	public static List<Genre> showGenre() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesServletWithDB");
		EntityManager em = emf.createEntityManager();
		List<Genre> actors = null;
		Query query = null;
		em.getTransaction().begin();
		query = em.createQuery("select a from Genre a");
		actors = query.getResultList();
		em.close();
		emf.close();
		return actors;
	}

	public static List<Movie> showAllMovies() {
		List<Movie> movies = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesServletWithDB");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("Select m from Movie m");
		movies = query.getResultList();
		em.close();
		emf.close();
		return movies;
	}

	public static void editMovie(int idMovie, String title, List<Actor> actors, List<Genre> genres) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesServletWithDB");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Movie> movies = showAllMovies();
		Movie movieSet = em.find(Movie.class, idMovie);
		movieSet.setTitle(title);
		movieSet.setActor(actors);
		movieSet.setGenre(genres);
		em.persist(movieSet);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	
	public static void deleteActor(int actorID, String firstName, String lastName){
		List<Movie> movieList = findAllMoviesWithAnActor(actorID);
		List<Actor> actorsList;
		for (int i = 0; i < movieList.size(); i++) {
			actorsList = movieList.get(i).getActor();
			for (int j = 0; j < actorsList.size() ; j++) {
//				String tempFirstName;
				int id;
				String tempLastName;
				id=actorsList.get(j).getId();
//				tempFirstName = actorsList.get(j).getFirstName();
				tempLastName = actorsList.get(j).getLastName();
				if(id==actorID){
					actorsList.remove(j);
					editMovie(movieList.get(i).getId(), movieList.get(i).getTitle(), actorsList, movieList.get(i).getGenre());
					break;
				}
			}
		}
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesServletWithDB");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Actor actor = em.find(Actor.class, actorID);
		em.remove(actor);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	private static List<Movie> findAllMoviesWithAnActor(int actorID) {
		List<Movie> list = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesServletWithDB");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select m from Movie m join m.actor a where a.id ='"+actorID+"'");
		list = query.getResultList();
		em.close();
		emf.close();
		return list;
	}

	// deleteGenre
	public static void deleteGenre(int genreId){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesServletWithDB");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Genre genre = em.find(Genre.class, genreId);
		em.remove(genre);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void deleteMovie(String title,String firstName, String lastName){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesServletWithDB");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("Select m from Movie m where m.title='" +title+"'");
		List<Movie> movies = query.getResultList();
		int temp = 0;
		boolean isFound = false;
		for (Movie movie : movies) {
			List<Actor> actors = movie.getActor();
			for (Actor actor : actors) {
				if (actor.getFirstName().equalsIgnoreCase(firstName)&&actor.getLastName().equalsIgnoreCase(lastName)) {
					temp=movie.getId();
					isFound = !isFound;
					break;
					
				}
			}
		}
		if (isFound) {
			Movie movieToRemove = em.find(Movie.class, temp);
			em.remove(movieToRemove);
			em.getTransaction().commit();
			
		}
		em.close();
		emf.close();
	}
}
