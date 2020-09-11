package LiftPrograms;

import java.util.ArrayList;
import java.util.Arrays;

import interfaces.ProgramInterface;

public class CatalystStarterProgram extends Program implements ProgramInterface {

	//VARIABLES////////////////////////////////////////////////////////
	String name = "Catalyst Starter Program";
	int programID = 1;
	protected String[] WorkoutforDay = {"Workout #1\r\n" + "Monday\r\n" + 
			"Clean & Jerk – 5 x 2+1\r\n" + 
			"Clean Pull – 3 x 3\r\n" + 
			"Back Squat – 3 x 5", 
			
			"Workout #2\r\n"+
			"Wednesday\r\n" + 
			"Snatch – 5 x 2\r\n" + 
			"Snatch Pull – 3 x 3\r\n" + 
			"Front Squat – 3 x 3", 
			
			"Workout #3\r\n"+
			"Thursday\r\n" + 
			"Power Snatch – 5 x 2\r\n" + 
			"Power Clean & Power Jerk – 5 x 2(1+1)\r\n" + 
			"Overhead Squat – 3 x 3", 
			
			"Workout #4\r\n"+
			"Saturday\r\n" + 
			"Snatch – heavy single\r\n" + 
			"Clean & Jerk – heavy single\r\n" + 
			"Front Squat – heavy single",
			
			"Workout #5\r\n"+
			"Monday\r\n" + 
			"Clean & Jerk – 5 x 3+1\r\n" + 
			"Clean Pull – 4 x 3\r\n" + 
			"Back Squat – 5 x 5",
			
			"Workout #6\r\n"+
			"Wednesday\r\n" + 
			"Snatch – 5 x 3\r\n" + 
			"Snatch Pull – 4 x 3\r\n" + 
			"Front Squat – 5 x 3",
			
			"Workout #7\r\n"+
			"Thursday\r\n" + 
			"Power Snatch – 5 x 3\r\n" + 
			"Power Clean & Power Jerk – 5 x 3(1+1)\r\n" + 
			"Overhead Squat – 5 x 3",
			
			"Workout #8\r\n"+
			"Saturday\r\n" + 
			"Snatch – 6 x 1\r\n" + 
			"Clean & Jerk – 6 x 1\r\n" + 
			"Front Squat – 3 x 1",
			
			"Workout #9\r\n"+
			"Monday\r\n" + 
			"Clean & Jerk – 5 x 1\r\n" + 
			"Clean Pull – 3 x 3\r\n" + 
			"Back Squat – 5 x 3",
			
			"Workout #10\r\n"+
			"Tuesday\r\n" + 
			"Power Snatch – 5 x 3\r\n" + 
			"Hang Clean – 5 x 2",
			
			"Workout #11\r\n"+
			"Wednesday\r\n" + 
			"Snatch – 5 x 1\r\n" + 
			"Snatch Pull – 3 x 3\r\n" + 
			"Front Squat – 5 x 2",
			
			"Workout #12\r\n"+
			"Thursday\r\n" + 
			"Hang Snatch – 5 x 3\r\n" + 
			"Power Clean & Power Jerk – 5 x 1+1\r\n" + 
			"Overhead Squat – 5 x 1",
			
			"Workout #13\r\n"+
			"Saturday\r\n" + 
			"Snatch – heavy single\r\n" + 
			"Clean & Jerk – heavy single\r\n" + 
			"Front Squat – heavy single",
			
			"Workout #14\r\n"+
			"Monday\r\n" + 
			"Clean & Jerk – 5 x 1\r\n" + 
			"Clean Pull – 3 x 2\r\n" + 
			"Back Squat – 5 x 2",
			
			"Workout #15\r\n"+
			"Tuesday\r\n" + 
			"Power Snatch – 5 x 2\r\n" + 
			"Power Clean – 5 x 2",
			
			"Workout #16\r\n"+
			"Wednesday\r\n" + 
			"Snatch – 5 x 1\r\n" + 
			"Snatch Pull – 3 x 2\r\n" + 
			"Front Squat – 3 x 2",
			
			"Workout #17\r\n"+
			"Thursday\r\n" + 
			"Hang Snatch – 5 x 2\r\n" + 
			"Power Clean & Power Jerk – 4 x 1+1\r\n" + 
			"Overhead Squat – 3 x 1",
			
			"Workout #18\r\n"+
			"Saturday\r\n" + 
			"Snatch – heavy single\r\n" + 
			"Clean & Jerk – heavy single\r\n" + 
			"Front Squat – heavy single" };
	protected int currentIteratorPos;
	protected int numElements = 18;
	
	
	//CONSTRUCTORS/////////////////////////////////////////////

	public CatalystStarterProgram() {
		super();
	}
	
	//METHODS///////////////////////////////////////////////////////
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		String CatStarterTemplate = "Week 1\r\n" + 
				"\r\n" + 
				"Choose weights by feel. Weights should be challenging this week, but comfortably below max efforts. "
				+ "\nUse the same weight for all prescribed sets of a given exercise.\r\n" + 
				"\r\n" + 
				"Monday\r\n" + 
				"Clean & Jerk – 5 x 2+1\r\n" + 
				"Clean Pull – 3 x 3\r\n" + 
				"Back Squat – 3 x 5\r\n" + 
				"\r\n" + 
				"Wednesday\r\n" + 
				"Snatch – 5 x 2\r\n" + 
				"Snatch Pull – 3 x 3\r\n" + 
				"Front Squat – 3 x 3\r\n" + 
				"\r\n" + 
				"Thursday\r\n" + 
				"Power Snatch – 5 x 2\r\n" + 
				"Power Clean & Power Jerk – 5 x 2(1+1)\r\n" + 
				"Overhead Squat – 3 x 3\r\n" + 
				"\r\n" + 
				"Saturday\r\n" + 
				"Snatch – heavy single\r\n" + 
				"Clean & Jerk – heavy single\r\n" + 
				"Front Squat – heavy single\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Week 2\r\n" + 
				"\r\n" + 
				"Use the same weights as week 1 with this increased volume. "
				+ "\nIf this feels too easy, you can increase the weight, but stay below absolute maximal effort.\r\n" + 
				"\r\n" + 
				"Monday\r\n" + 
				"Clean & Jerk – 5 x 3+1\r\n" + 
				"Clean Pull – 4 x 3\r\n" + 
				"Back Squat – 5 x 5\r\n" + 
				"\r\n" + 
				"Wednesday\r\n" + 
				"Snatch – 5 x 3\r\n" + 
				"Snatch Pull – 4 x 3\r\n" + 
				"Front Squat – 5 x 3\r\n" + 
				"\r\n" + 
				"Thursday\r\n" + 
				"Power Snatch – 5 x 3\r\n" + 
				"Power Clean & Power Jerk – 5 x 3(1+1)\r\n" + 
				"Overhead Squat – 5 x 3\r\n" + 
				"\r\n" + 
				"Saturday\r\n" + 
				"Snatch – 6 x 1\r\n" + 
				"Clean & Jerk – 6 x 1\r\n" + 
				"Front Squat – 3 x 1\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Week 3\r\n" + 
				"\r\n" + 
				"Increase the weights from last week as you’re able to.\r\n" + 
				"\r\n" + 
				"Monday\r\n" + 
				"Clean & Jerk – 5 x 1\r\n" + 
				"Clean Pull – 3 x 3\r\n" + 
				"Back Squat – 5 x 3\r\n" + 
				"\r\n" + 
				"Tuesday\r\n" + 
				"Power Snatch – 5 x 3\r\n" + 
				"Hang Clean – 5 x 2\r\n" + 
				"\r\n" + 
				"Wednesday\r\n" + 
				"Snatch – 5 x 1\r\n" + 
				"Snatch Pull – 3 x 3\r\n" + 
				"Front Squat – 5 x 2\r\n" + 
				"\r\n" + 
				"Thursday\r\n" + 
				"Hang Snatch – 5 x 3\r\n" + 
				"Power Clean & Power Jerk – 5 x 1+1\r\n" + 
				"Overhead Squat – 5 x 1\r\n" + 
				"\r\n" + 
				"Saturday\r\n" + 
				"Snatch – heavy single\r\n" + 
				"Clean & Jerk – heavy single\r\n" + 
				"Front Squat – heavy single\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Week 4\r\n" + 
				"\r\n" + 
				"Increase the weights from last week as you’re able to. "
				+ "\nPush for max effort singles on Saturday.\r\n" + 
				"\r\n" + 
				"Monday\r\n" + 
				"Clean & Jerk – 5 x 1\r\n" + 
				"Clean Pull – 3 x 2\r\n" + 
				"Back Squat – 5 x 2\r\n" + 
				"\r\n" + 
				"Tuesday\r\n" + 
				"Power Snatch – 5 x 2\r\n" + 
				"Power Clean – 5 x 2\r\n" + 
				"\r\n" + 
				"Wednesday\r\n" + 
				"Snatch – 5 x 1\r\n" + 
				"Snatch Pull – 3 x 2\r\n" + 
				"Front Squat – 3 x 2\r\n" + 
				"\r\n" + 
				"Thursday\r\n" + 
				"Hang Snatch – 5 x 2\r\n" + 
				"Power Clean & Power Jerk – 4 x 1+1\r\n" + 
				"Overhead Squat – 3 x 1\r\n" + 
				"\r\n" + 
				"Saturday\r\n" + 
				"Snatch – heavy single\r\n" + 
				"Clean & Jerk – heavy single\r\n" + 
				"Front Squat – heavy single";
		
		return CatStarterTemplate;
	}


	@Override
	public void resetIterator() {
		currentIteratorPos = 0;
		
	}
	
	@Override
	public String getNextWorkout() {
		String next = WorkoutforDay[currentIteratorPos];
		currentIteratorPos++;
		if (currentIteratorPos == numElements) {
			resetIterator();
		}
		return next;
	}
	
	public String getPrevWorkout() {
		currentIteratorPos--;
		if (currentIteratorPos < 0) {
			currentIteratorPos = numElements -1;
			String prev = WorkoutforDay[currentIteratorPos];
			return prev;
		}
		else {
			String prev = WorkoutforDay[currentIteratorPos];
			return prev;
		}
	}

}
