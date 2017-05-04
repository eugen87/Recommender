package movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class GetMovies {

	private Connection con;
		
	 public GetMovies() {
		con = DBConnection.getInstance().getDBcon();
	}
		
		public Movie getMovie(String movieId) {
			ResultSet results;
			Movie movie = new Movie();
			PreparedStatement prepSt = null;
			
			String query = "SELECT MovieId, Title FROM MOVIES WHERE MovieId = ?";

			try {
				prepSt = con.prepareStatement(query);
				prepSt.setString(1, movieId);
				prepSt.setQueryTimeout(5);
				results = prepSt.executeQuery();

				if (results.next()) {
					movie = buildMovie(results);
					prepSt.close();
				} else {
					movie = null;
				}
			} catch (Exception e) {
				System.out.println("Query exception: " + e);
			}
			return movie;
		}
	
	private Movie buildMovie(ResultSet results){
		Movie mov = new Movie();
		try{
			mov.setMoviId(results.getString("MovieId"));
			mov.setTitle(results.getString("Title"));
		} catch (Exception e) {
			System.out.println("Error in building the Customer object");
		}
		return mov;
	}
	
	
}
