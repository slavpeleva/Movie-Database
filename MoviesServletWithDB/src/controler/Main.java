package controler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import model.Actor;
import model.Genre;
import model.Movie;

public class Main {

	public static void main(String[] args) {
	RequestMyReq req = new RequestMyReq();
//	req.showActors();
	List<Actor> actor= RequestMyReq.showActors();
	List<Genre> genre= RequestMyReq.showGenre();
//	req.insertGenre("Adventure");
//	Movie movie = new Movie();
//	movie.setTitle("Proba");
	
//RequestMyReq.deleteMovie("kk", "Test", "Test");
	//RequestMyReq.deleteActor(1251, "Test", "Test");

	RequestMyReq.insertMovie("Daaa", actor, genre);
	}

}
