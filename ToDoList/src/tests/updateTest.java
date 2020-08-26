package tests;

import java.sql.*;

import database.*;

public class updateTest {

	//METHOD to Display the names in the users database
		public void displayUsers() throws ClassNotFoundException, SQLException {
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
	
	
	public void createDBTest(String firstName, String lastName)throws SQLException, ClassNotFoundException {
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
	
	
	public void updateDBTest(String firstName, String newFirstName, String lastName, String newLastName) throws ClassNotFoundException, SQLException {
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
		displayUsers();
		
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
		displayUsers();
					
	}
	
	
	public void deleteDBTest(String firstName, String lastName) throws ClassNotFoundException, SQLException {
	//Connect to DB
		Connection connection = databaseConnection.connectDB();
		
	//Create a statement
		String userDelete = 
				"DELETE FROM users " +
				"WHERE last_name = ? AND first_name = ?";
		
		PreparedStatement userDeleteStatement = connection.prepareStatement(userDelete);
		
	//Call helper method to display info
		System.out.println("BEFORE THE DELETE...");
		displayUsers();
	
	//Set Parameters
		userDeleteStatement.setString(1, lastName);
		userDeleteStatement.setString(2,  firstName);
	
	//Execute Update
		userDeleteStatement.executeUpdate();
		connection.close();
		
	//Call helper method to verify delete
		System.out.println("AFTER THE DELETE...");
		displayUsers();
		
	}
	

	//Main Method creates instance of class(must create an instance of a non static method)
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		//updateTest update = new updateTest();
		//String firstName = "Jane";
		//String lastName = "Doe";
		
		
		//update.deleteDBTest(firstName, lastName); //delete old John Doe
		
		//update.createDBTest(firstName, lastName); //Re-add john doe
		//String newFirstName = "Jane";
		//String newLastName = "Doe";
		
		//update.updateDBTest(firstName, newFirstName, lastName, newLastName); //change john to jane
		
		taskModify taskModify = new taskModify();
		//System.out.println(taskModify.getUserId("Hallacker", "Robert"));
		//taskModify.insertTask("Hallacker", "Robert", "Programming", "Work on TodoList", "High", "2 Weeks");
		String string = taskModify.displayAllTasks("Hallacker", "Robert");
			System.out.println(string);
	
	}

}
