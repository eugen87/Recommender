package main;

import movie.GetMovies;
import movie.Movie;

public class test {

	public static void main(String[] args){
		
		GetMovies movies = new GetMovies();
		Movie mov = new Movie();
		mov = movies.getMovie("tt0012349");
		
		System.out.println(mov.title);
	}
	
}
