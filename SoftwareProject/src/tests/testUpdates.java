package tests;

import java.sql.*;
import database.*;
import updates.*;

public class testUpdates {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	//ADD an exercise:	
		String exerciseName = "Bicep Curl";
		String exerciseDescription = "This is the description of the bicep curl";
		
		UpdateExercise update = new UpdateExercise();
		update.addExercise(exerciseName, exerciseDescription);
		
///////////////////////////////////////////////////////////////////////
		
	//Print the Exercise Table:
		Connection connection = null;
		connection = databaseConnection.connectDB();
		
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
		
		
	//REMOVE an exercise:
		update.removeExercise(exerciseName);

	//Print the Exercise Table:
		System.out.println();
		
		System.out.println("ID \tExercise Name \tExercise Description");
		ResultSet exercises2 = statement.executeQuery(exercisesQuery);
		while(exercises2.next()) {
			strOutput = exercises2.getInt("exerciseId") + "\t";
			strOutput += exercises2.getString("exerciseName") + "\t";
			strOutput += exercises2.getString("exerciseDescription");
			System.out.println(strOutput);
		}
		connection.close();

		System.out.println(update.getVideo("Bench Press"));
//Add Sets
		/*	//Add a set ISSUE with FK_WorkoutID
		int setNumber = 1;
		int repetitions = 5;
		int weight = 225;
		
		UpdateSet updateSet = new UpdateSet();
		updateSet.addSet(setNumber, repetitions, weight);
		*/
		
/////////////////////////////////////////////////////////////////////////////
//Print the Sets Table
		/*
	System.out.println();

	String setQuery = "SELECT * FROM sets";
	ResultSet sets = statement.executeQuery(setQuery);

	System.out.println("SETS");
	while(sets.next()) {
		strOutput = sets.getInt("SetNumber") + "\t";
		strOutput += sets.getInt("Repetitions") + "\t";
		strOutput += sets.getInt("Weight");
		System.out.println(strOutput);
		}
		 */
	}
}
