package tests;

import java.sql.ResultSet;
import java.sql.SQLException;

import updates.UpdateSet;

public class testgui {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		String strOutput = "";
		UpdateSet UpdateSet = new UpdateSet();
	
		UpdateSet.retrieveSet(1);
		System.out.println(UpdateSet.retrieveSet(1));

		

		/*	int exerciseID = 0;
		
		String exerciseTxt = "Bench Press";
		if (exerciseTxt.equals("Back Squat")) {
			 exerciseID = 1;
		}		
		if (exerciseTxt.equals("Bench Press")){
			exerciseID = 2;
		}
		if (exerciseTxt.equals("Overhead Press")){
			exerciseID = 3;
		}
		if (exerciseTxt.equals("Deadlift")){
			exerciseID = 4;
		}
		if (exerciseTxt.equals("Clean & Jerk")){
			exerciseID = 5;
		}
		if (exerciseTxt.equals("Clean Pull")){
			exerciseID = 6;
		}
		if (exerciseTxt.equals("Snatch")){
			exerciseID = 7;
		}
		if (exerciseTxt.equals("Snatch Pull")){
			exerciseID = 8;
		}
		if (exerciseTxt.equals("Front Squat")){
			exerciseID = 9;
		}
		if (exerciseTxt.equals("Power Snatch")){
			exerciseID = 10;
		}
		if (exerciseTxt.equals("Power Clean & Power Jerk")){
			exerciseID = 11;
		}
		if (exerciseTxt.equals("Overhead Squat")){
			exerciseID = 12;
		}
		if (exerciseTxt.equals("Hang Clean")){
			exerciseID = 13;
		}
		if (exerciseTxt.equals("Power Clean")){
			exerciseID = 14;
		}
		
		System.out.println(exerciseID);
		
		


		
		try {
			UpdateSet.addSet(1, 1, 5, 225);
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	*/
	}
	
}
