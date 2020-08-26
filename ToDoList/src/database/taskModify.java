package database;

import java.sql.*;

public class taskModify {

//Constructor
	public taskModify() {
		
	}
	
//Methods
	
	public int getUserId(String lastName, String firstName) throws ClassNotFoundException, SQLException {
		
	//Connect to DB
		Connection connection = databaseConnection.connectDB();
		
	//prepare Statement			
		String getuserID = "SELECT userID FROM users WHERE last_name = ? AND first_name = ?";
		PreparedStatement userIDStatement = connection.prepareStatement(getuserID);

	//Set Parameters
		userIDStatement.setString(1,  lastName);
		userIDStatement.setString(2, firstName);
	
	//Execute Query
		ResultSet userIDResult = userIDStatement.executeQuery();
		
	//Process Results
		userIDResult.next(); //move the cursor to the data
		int userId = userIDResult.getInt(1);
	
	//Close Connections
		userIDResult.close();
		userIDStatement.close();
		connection.close();
	
		//Return
		return userId;		
	}
	
	public int getTaskId() {
		
	}
	
	public String displayAllTasks(String lastName, String firstName) throws ClassNotFoundException, SQLException {
		
	//Call database connection
		Connection connection = databaseConnection.connectDB();
	
	//Get the User ID
		int userId = getUserId(lastName, firstName);
		
	//Create Statement
		String taskDisplay = "SELECT * FROM tasks WHERE fk_user_ID = ?";
		PreparedStatement displayTaskStatement = connection.prepareStatement(taskDisplay);
		
	//Set Parameters
		displayTaskStatement.setInt(1,  userId);
		
	//Execute Query
		ResultSet taskDisplayRS = displayTaskStatement.executeQuery();
		
	//Process Result Set
		//Get Column Names
			ResultSetMetaData rsmd = taskDisplayRS.getMetaData();
			String columns = rsmd.getColumnName(1) + "\t";
			columns += rsmd.getColumnName(2) + "\t";
			columns += rsmd.getColumnName(3) + "\t";
			columns += rsmd.getColumnName(4) + "\t";
			columns += rsmd.getColumnName(5) + "\t";
			columns += rsmd.getColumnName(6) + "\t";
			columns += rsmd.getColumnName(7) + "\t";
		
		//Get Data
			String taskDataSt = "";
			while (taskDisplayRS.next()) {
				taskDataSt = taskDisplayRS.getInt("task_id") + "\t";
				taskDataSt += taskDisplayRS.getString("task_type") + "\t";
				taskDataSt += taskDisplayRS.getString("task_name") + "\t";
				taskDataSt += taskDisplayRS.getString("task_priority") + "\t";
				taskDataSt += taskDisplayRS.getDate("task_date_created") + "\t";
				taskDataSt += taskDisplayRS.getString("task_est_complete_time") + "\t";
				taskDataSt += taskDisplayRS.getInt("fk_user_id") + "\t";	
			}
		
	//Clean up Environment
		connection.close();
		taskDisplayRS.close();
		displayTaskStatement.close();
	
	//Return	
		String taskReturnStr = columns + "\n" + taskDataSt;
		return taskReturnStr;
	}
	
	public void insertTask(String lastName, String firstName, 
			String taskType, String taskName, String taskPriority, String estCompleteTime ) throws ClassNotFoundException, SQLException {
		
		int userID = getUserId(lastName, firstName);
		
	//Open a connection
		Connection connection = databaseConnection.connectDB();
		
	//Create a statement
		String taskInsert = "INSERT INTO tasks(task_type, task_name, task_priority, task_est_complete_time, fk_user_ID)"
				+ " VALUES(?,?,?,?,?)";
		PreparedStatement insertTaskPS = connection.prepareStatement(taskInsert);
	
	//Set Parameters
		insertTaskPS.setString(1, taskType);
		insertTaskPS.setString(2, taskName);
		insertTaskPS.setString(3, taskPriority);
		insertTaskPS.setString(4, estCompleteTime);
		insertTaskPS.setInt(5, userID);
		
	//Execute Query
		insertTaskPS.executeUpdate();
		System.out.println("Update Complete");
	
	//Clean up 	
		connection.close();
		insertTaskPS.close();
		
	}
	
	public void deleteTask() throws ClassNotFoundException, SQLException {
	
	//Open a new Connection
		Connection connection = databaseConnection.connectDB();
	
	//Prepare a Statement
		String taskDelete = "DELETE FROM tasks WHERE "
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
