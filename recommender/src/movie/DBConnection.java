package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String connectionUrl = "jdbc:sqlserver://eugenb.database.windows.net:1433;database=IMDB;user=eugen@eugenb;password={imdb2017!};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
	
	private static Connection con;
	private static DBConnection instance = null;
	
	private DBConnection() {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected!");
		} catch (SQLException e) {
			System.out.println("Problems with the connection to the database");
			System.out.println(e.getMessage());
			System.out.println(connectionUrl);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getDBcon() {
		return con;
	}
	
	public static void closeConnection() {
		try {
			con.close();
			System.out.println("The connection is closed.");
		} catch (SQLException e) {
			System.out.println("Error trying to close the database " + e.getMessage());
		}
	}
	
	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
}
