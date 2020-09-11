package tests;
import java.sql.*;
import database.databaseConnection;

public class databaseConnectionTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//Call Database Connection
		Connection connection = null;
		connection = databaseConnection.connectDB();

		//Test Statements
		Statement statement = connection.createStatement();
		
		String exercisesQuery = "SELECT * FROM exercises";
		ResultSet exercises = statement.executeQuery(exercisesQuery);
		
		String strOutput = "";
		
		System.out.println("ID \tExercise Name \tExercise Description");
		while(exercises.next()) {
			strOutput = exercises.getInt("exerciseId") + "\t";
			strOutput += exercises.getString("exerciseName") + "\t";
			strOutput += exercises.getString("exerciseDescription");
			System.out.println(strOutput);
		}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		Statement statement2 = connection.createStatement();
		
		String setQuery2 = "SELECT Date, exerciseName, SetNumber, Repetitions, Weight "
				+ "FROM workout w "
				+ "INNER JOIN sets s ON w.workoutID = s.FK_WorkoutID "
				+ "INNER JOIN exercises e ON e.exerciseId = s.FK_Exercise_ID";
	
		ResultSet sets = statement2.executeQuery(setQuery2);
		System.out.println(" \nDate \t\tExercise Name \tSet \tReps \tWeight");
		while(sets.next()) {
			strOutput = sets.getDate("Date") + "\t";
			strOutput += sets.getString("exerciseName") + "\t";
			strOutput += sets.getString("SetNumber") + "\t";
			strOutput += sets.getInt("Repetitions") + "\t";
			strOutput += sets.getInt("Weight") + "\t";
			
			System.out.println(strOutput);
			
		}
		
		connection.close();
		
	}
}
