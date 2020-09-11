package updates;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import database.databaseConnection;

//Liang Textbook Page 1197
public class UpdateExercise {

	public UpdateExercise() {
		
	}
	
	public void addExercise(String exerciseName, String exerciseDescription)throws SQLException, ClassNotFoundException{
			
		String exerciseInsertSQL = 
				"INSERT INTO exercises(exerciseName, exerciseDescription) VALUES(?,?)";
		
		try (Connection connection = databaseConnection.connectDB(); 
			PreparedStatement preparedStatement = connection.prepareStatement(exerciseInsertSQL)){
				preparedStatement.setString(1, exerciseName);
				preparedStatement.setString(2, exerciseDescription);
				preparedStatement.executeUpdate();		
				connection.close();
		}
		
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void removeExercise(String exerciseName) throws SQLException, ClassNotFoundException{
		
		String exerciseRemoveSQL = 
				"DELETE FROM exercises WHERE exerciseName = ?";
		
		try (Connection connection = databaseConnection.connectDB(); 
				PreparedStatement preparedStatement = connection.prepareStatement(exerciseRemoveSQL)){
					preparedStatement.setString(1, exerciseName);
					preparedStatement.executeUpdate();		
					//connection.close();
			}
			
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	public String getVideo(String exerciseName)  throws SQLException, ClassNotFoundException{
		
		String exerciseVideo = "";
		ArrayList<String> list = new ArrayList<String>();
		
		String getExerciseVideoSQL = "SELECT exerciseVideo FROM exercises WHERE exerciseName = ?";
	
		
		try (Connection connection = databaseConnection.connectDB();
				PreparedStatement preparedStatement = connection.prepareStatement(getExerciseVideoSQL)){
					preparedStatement.setString(1, exerciseName);
					
				ResultSet exerciseVideoLink = preparedStatement.executeQuery();		
					
				while(exerciseVideoLink.next()) {
					list.add(exerciseVideoLink.getString(1));
				}
		
				exerciseVideo = list.get(0);
				connection.close();
				return exerciseVideo;
		}
	
		catch(Exception ex) {
			ex.printStackTrace();
		}

		return exerciseVideo;
		
	
	}

	public String getExerciseDescription(String exerciseName) throws SQLException, ClassNotFoundException{
		
		String exerciseDescription = "";
		ArrayList<String> list2 = new ArrayList<String>();
		
		String getExerciseDescSQL = "SELECT exerciseDescription FROM exercises WHERE exerciseName = ?";
		
		try (Connection connection = databaseConnection.connectDB();
				PreparedStatement preparedStatement = connection.prepareStatement(getExerciseDescSQL)){
					preparedStatement.setString(1, exerciseName);
		
				ResultSet exerciseDescriptionRS = preparedStatement.executeQuery();		
					
					while(exerciseDescriptionRS.next()) {
						list2.add(exerciseDescriptionRS.getString(1));
					}
			
					exerciseDescription = list2.get(0);
					connection.close();
					return exerciseDescription;
			}
		
			catch(Exception ex) {
				ex.printStackTrace();
			}

			return exerciseDescription;			
		
		
	}

}