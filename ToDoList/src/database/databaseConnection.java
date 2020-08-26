package database;
import java.sql.*;

public class databaseConnection {

	public static Connection connectDB()throws SQLException, ClassNotFoundException {
	
	//Load the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	//Connect to DB
		String dbUrl = "jdbc:mysql://localhost/tdl";
		Connection connection = DriverManager.getConnection(dbUrl, "root", ""); //parameters are url, username, password
		return connection;
		
	}
}
