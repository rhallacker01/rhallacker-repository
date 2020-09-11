package tests;

import java.sql.*;
import java.util.ArrayList;

import database.databaseConnection;
import updates.UpdateSet;

public class testUpdateSet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		UpdateSet set1 = new UpdateSet();
	//	ArrayList<Integer> list = new ArrayList<Integer>();
		String strOutput = "";
		
		Connection connection = null;
		connection = databaseConnection.connectDB();
		
		Statement statement = connection.createStatement();
		
		String setQuery = "SELECT * FROM sets";
		ResultSet sets = statement.executeQuery(setQuery);

		System.out.println("FK_WorkoutID \t SetNumber\t Reps\t weight");
		//System.out.println("SETS");
		while(sets.next()) {
			strOutput = sets.getInt("FK_WorkoutID") + "\t\t";
			strOutput += sets.getInt("SetNumber") + "\t\t";
			strOutput += sets.getInt("Repetitions") + "\t\t";
			strOutput += sets.getInt("Weight");
			System.out.println(strOutput);
			}
		
		//list = set1.retrieveSet(1);
		//System.out.println(list);
		
		
		
		
	}

}
