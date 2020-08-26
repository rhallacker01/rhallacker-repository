package tests;

import java.sql.*;
import database.databaseConnection;


public class dbTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	//Call Database Connection
		System.out.println("Connecting to Database");
		Connection connection = databaseConnection.connectDB();
		System.out.println("Connected");
		
	//Create Statement
		Statement statement = connection.createStatement();
		
		ResultSet testUser = statement.executeQuery("SELECT * FROM users");
		System.out.println("Displaying Users");
	
	//Process Result Set
		String userOutput = "";
		while(testUser.next()) {
			userOutput = testUser.getString("first_name") + " " + testUser.getString("last_name");
			System.out.println(userOutput);
		}
	//Close Connection
		connection.close();
		System.out.println("Connection Closed");
	}

}
