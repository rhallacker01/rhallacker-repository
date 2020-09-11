package updates;
import java.sql.*;
import java.util.ArrayList;

import database.databaseConnection;

public class UpdateSet {

	public UpdateSet() {
		
	}
	
	public void addSet(int exerciseID, int setNumber, int Repetitions, int Weight, int workoutID)
			throws SQLException, ClassNotFoundException{
		

		String setInsertSQL = 
				"INSERT INTO sets(FK_ExerciseID, setNumber, Repetitions, Weight, FK_WorkoutID) "
				+ "VALUES(?,?,?,?,?)";
		
		try (Connection connection = databaseConnection.connectDB(); 
			PreparedStatement preparedStatement = connection.prepareStatement(setInsertSQL)){
				preparedStatement.setInt(1, exerciseID);
				preparedStatement.setInt(2, setNumber);
				preparedStatement.setInt(3, Repetitions);
				preparedStatement.setInt(4, Weight);
				preparedStatement.setInt(5, workoutID);	
				preparedStatement.executeUpdate();
				preparedStatement.close();
				connection.close();
		}
		
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	

/*	//This section needs to be added as a FK for one of the other tables, as is it will add another exercise to the table
		String exerciseTableInsertSQL = 
				"INSERT INTO exercise(exercise) VALUES(?)";
		
		try (Connection connection = databaseConnection.connectDB();
				PreparedStatement preparedStatement = connection.prepareStatement(exerciseTableInsertSQL)){
				preparedStatement.setString(1, exercise);
				preparedStatement.executeUpdate();
				connection.close();
		}
	
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		*/
	}
	
	public void createWorkout(int workoutNum, String date) throws SQLException, ClassNotFoundException{
		String workoutTableInsertSQL = 
				"INSERT INTO workout(date, workoutNum) VALUES(?,?)";
		
		try (Connection connection = databaseConnection.connectDB();
				PreparedStatement preparedStatement = connection.prepareStatement(workoutTableInsertSQL)){
			  //preparedStatement.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now())); //Current Date
				preparedStatement.setDate(1, java.sql.Date.valueOf(date));
				preparedStatement.setInt(2,  workoutNum);
				preparedStatement.executeUpdate();
				preparedStatement.close();
				connection.close();
		}
		
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public int getExerciseID(String exerciseTxt) {
		int exerciseID = 0;
		if (exerciseTxt.equalsIgnoreCase("Back Squat")) {
			 exerciseID = 1;
		}		
		if (exerciseTxt.equalsIgnoreCase("Bench Press")){
			exerciseID = 2;
		}
		if (exerciseTxt.equalsIgnoreCase("Overhead Press")){
			exerciseID = 3;
		}
		if (exerciseTxt.equalsIgnoreCase("Deadlift")){
			exerciseID = 4;
		}
		if (exerciseTxt.equalsIgnoreCase("Clean & Jerk")){
			exerciseID = 5;
		}
		if (exerciseTxt.equalsIgnoreCase("Clean Pull")){
			exerciseID = 6;
		}
		if (exerciseTxt.equalsIgnoreCase("Snatch")){
			exerciseID = 7;
		}
		if (exerciseTxt.equalsIgnoreCase("Snatch Pull")){
			exerciseID = 8;
		}
		if (exerciseTxt.equalsIgnoreCase("Front Squat")){
			exerciseID = 9;
		}
		if (exerciseTxt.equalsIgnoreCase("Power Snatch")){
			exerciseID = 10;
		}
		if (exerciseTxt.equalsIgnoreCase("Power Clean & Power Jerk")){
			exerciseID = 11;
		}
		if (exerciseTxt.equalsIgnoreCase("Overhead Squat")){
			exerciseID = 12;
		}
		if (exerciseTxt.equalsIgnoreCase("Hang Clean")){
			exerciseID = 13;
		}
		if (exerciseTxt.equalsIgnoreCase("Power Clean")){
			exerciseID = 14;
		}
		return exerciseID;
	}
	
	public int getWorkoutID(String dateTxt) throws SQLException, ClassNotFoundException{
		
		int workoutID = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		String getWorkoutID = "SELECT WorkoutID FROM workout WHERE Date = ?";
		
		try (Connection connection = databaseConnection.connectDB();
				PreparedStatement preparedStatement = connection.prepareStatement(getWorkoutID)){
					preparedStatement.setDate(1, java.sql.Date.valueOf(dateTxt));
					
				ResultSet RSworkoutID = preparedStatement.executeQuery();
				
				while(RSworkoutID.next()) {
					list.add(RSworkoutID.getInt(1));
				}
				
				workoutID = list.get(0);
				connection.close();
				return workoutID;
		}
			
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return workoutID;
	}

	//THis method needs to have the column names updated
	public String retrieveSet(int workoutID) throws SQLException, ClassNotFoundException{
		
		//ArrayList<E> list = new ArrayList<E>();
		//ResultSet sets = null;
		String strOutput = "";
		String setReturnStr = "";
		
		String retrieveSetSQL = 
				"SELECT ExerciseName, SetNumber, Repetitions, Weight, Date\r\n" + 
				"FROM sets\r\n" + 
				"JOIN workout ON workout.WorkoutID = sets.FK_WorkoutID\r\n" + 
				"JOIN exercises ON exercises.exerciseID = sets.FK_ExerciseID\r\n" + 
				"WHERE workout.WorkoutNum = ?";
		
		try (Connection connection = databaseConnection.connectDB();
			PreparedStatement preparedStatement = connection.prepareStatement(retrieveSetSQL)){
				preparedStatement.setInt(1, workoutID);
		
			ResultSet sets = preparedStatement.executeQuery();
			
			ResultSetMetaData rsmd = sets.getMetaData();
			String columns = rsmd.getColumnName(1) + "\t";
			columns +=rsmd.getColumnName(2) + "\t";
			columns +=rsmd.getColumnName(3) + "\t";
			columns +=rsmd.getColumnName(4) + "\t";
			columns +=rsmd.getColumnName(5);
		
			
			while (sets.next()) {
				strOutput = sets.getString("ExerciseName") + "\t";
				strOutput += sets.getInt("SetNumber") + "\t\t";
				strOutput += sets.getInt("Repetitions") + "\t\t";
				strOutput += sets.getInt("Weight") + "\t";
				strOutput += sets.getDate("Date");
				setReturnStr += strOutput + "\n";
			}	
			
			setReturnStr = columns + "\n" +  setReturnStr;
			return setReturnStr;
	
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}

		return setReturnStr;
	}
	
	
	
	
	
	
	
	
}
