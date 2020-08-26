package database;

import java.sql.*;

public class userModify {

//CONSTRUCTORS	
	public userModify() {
		
	}
	//ADD more info to user table, Create more constructors, pass the variables to the constructor
	
//METHODS	
	
	//METHOD to Display the names in the users database
		public void displayAllUsers() throws ClassNotFoundException, SQLException {
		//Call Database Connection
			Connection connection = databaseConnection.connectDB();
			
		//Create Statement
			Statement statement = connection.createStatement();
			
			ResultSet testUser = statement.executeQuery("SELECT * FROM users");

		
		//Process Result Set
			String userOutput = "";
			while(testUser.next()) {
				userOutput = testUser.getString("first_name") + " " + testUser.getString("last_name");
				System.out.println(userOutput);
			}
		//Close Connection
			connection.close();
		}
	
	//Display User
		public String displayUser(String lastName, String firstName) throws ClassNotFoundException, SQLException {
		//call Database Connection
			Connection connection = databaseConnection.connectDB();
		
		//Create Statement
			String userDisplay = 
					"SELECT first_name, last_name FROM users" +
					"WHERE last_name = ? AND first_name = ?";
			
			PreparedStatement userDisplayStatement = connection.prepareStatement(userDisplay);
		
		//Set Parameters
			userDisplayStatement.setString(1,  lastName);
			userDisplayStatement.setString(2,  firstName);
			
		//Execute Query
			ResultSet userDisplaySet = userDisplayStatement.executeQuery();
			connection.close();
		
		//Process Result Set
			String userName = "";
			while(userDisplaySet.next()) {
				userName = userDisplaySet.getString("first_name") + " " +
						userDisplaySet.getString("last_name");
			}
			
			return userName;
		}
		
	//Create User	
		public void createUser(String firstName, String lastName)throws SQLException, ClassNotFoundException {
			
			String userInsert = "INSERT INTO users(first_name, last_name) VALUES(?,?)";
			
			try (Connection connection = databaseConnection.connectDB();
					PreparedStatement userCreateStatement = connection.prepareStatement(userInsert)){
					userCreateStatement.setString(1,  firstName);
					userCreateStatement.setString(2, lastName);
					userCreateStatement.executeUpdate();
					connection.close();
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	
	//Update User	
		public void updateUser(String firstName, String newFirstName, String lastName, String newLastName) throws ClassNotFoundException, SQLException {
			//Connect to DB	
				Connection connection = databaseConnection.connectDB();
			
			//Create a statement
				String userUpdate = 
							"UPDATE users " +
							"SET first_name = ?, last_name = ? " + 
							"WHERE first_name = ? AND last_name= ?";
				
				PreparedStatement userUpdateStatement = connection.prepareStatement(userUpdate);
			
			//Call helper method to display the info
				System.out.println("BEFORE THE UPDATE...");
				displayAllUsers();
				
			//Set Parameters
				userUpdateStatement.setString(1,  newFirstName);
				userUpdateStatement.setString(2,  newLastName);
				userUpdateStatement.setString(3,  firstName);
				userUpdateStatement.setString(4,  lastName);
			
			//Execute Update
				userUpdateStatement.executeUpdate();
				connection.close();
				
			
			//Call helper method to display info
				System.out.println("AFTER THE UPDATE...");
				displayAllUsers();
							
			}
	
	//Delete User
		public void deleteUser(String firstName, String lastName) throws ClassNotFoundException, SQLException {
			//Connect to DB
				Connection connection = databaseConnection.connectDB();
				
			//Create a statement
				String userDelete = 
						"DELETE FROM users " +
						"WHERE last_name = ? AND first_name = ?";
				
				PreparedStatement userDeleteStatement = connection.prepareStatement(userDelete);
				
			//Call helper method to display info
				System.out.println("BEFORE THE DELETE...");
				displayAllUsers();
			
			//Set Parameters
				userDeleteStatement.setString(1, lastName);
				userDeleteStatement.setString(2,  firstName);
			
			//Execute Update
				userDeleteStatement.executeUpdate();
				connection.close();
				
			//Call helper method to verify delete
				System.out.println("AFTER THE DELETE...");
				displayAllUsers();
				
			}
}
