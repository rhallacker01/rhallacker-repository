package GUI;


import java.sql.SQLException;

import LiftPrograms.CatalystStarterProgram;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import updates.UpdateExercise;
import updates.UpdateSet;

public class graphicalUserInterface extends Application {
	@Override
	public void start (Stage primaryStage) {
		
		primaryStage.setTitle("Weightlifting Tracker");
		
		CatalystStarterProgram catStart = new CatalystStarterProgram();
		UpdateExercise UpdateExercise = new UpdateExercise();
		UpdateSet UpdateSet = new UpdateSet();
	//Title Scene
		
		//Title Text		
			Text titleText = new Text();
			titleText.setText("\n\nAdvanced Software Project Weightlifting Tracker ");
			titleText.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		
		//Title Buttons
			Button btEnter = new Button("Enter");
			btEnter.setStyle("-fx-font-size: 15pt");
		
		//Title Pane
			BorderPane titlePane = new BorderPane();
			titlePane.setTop(titleText);
			titlePane.setAlignment(titleText, Pos.CENTER);
			titlePane.setCenter(btEnter);
	
			Scene TitleScene = new Scene(titlePane,  600, 500);

			primaryStage.setScene(TitleScene);
			primaryStage.show();
		
	//Home Page
		//Home Screen Text
			Text homeScreenTxt = new Text();
			homeScreenTxt.setText("\n\nWeightlifting Tracker");
			homeScreenTxt.setFont(Font.font("Verdana", 30));
		
		//Home Buttons
			Button btProgramTemplate = new Button("Program Templates");
				btProgramTemplate.setStyle("-fx-font-size: 20pt");
			Button btDailyWorkout = new Button("Daily Workout");
				btDailyWorkout.setStyle("-fx-font-size: 20pt");
			Button btWorkoutDescription = new Button("Exercise Descriptions");
				btWorkoutDescription.setStyle("-fx-font-size: 20pt");
		
		//Home Pane
			BorderPane homeScreenPane = new BorderPane();
			homeScreenPane.setTop(homeScreenTxt);
				homeScreenPane.setAlignment(homeScreenTxt, Pos.CENTER);
			
			VBox btVboxHomeScreen = new VBox();
				btVboxHomeScreen.getChildren().addAll(btProgramTemplate,btDailyWorkout, btWorkoutDescription);
				btVboxHomeScreen.setAlignment(Pos.CENTER);
			homeScreenPane.setCenter(btVboxHomeScreen);
			homeScreenPane.setAlignment(btVboxHomeScreen, Pos.CENTER);

				
			Scene homeScene = new Scene(homeScreenPane, 700, 600);
		
	//Template Page
		//Template Buttons
			Button btBack = new Button("Home Screen");
			Button btCatalystStarter = new Button("Catalyst Starter Program");

		//Template Text
			TextArea templateTextArea = new TextArea();
			templateTextArea.setWrapText(true);
			//templateTextArea.setStyle("fx-text-inner-color: black;");
			//templateTextArea.setStyle("fx-opacity: 1.0;");
			//templateTextArea.setStyle("overflow-y: scroll;");
		
		//Template Scroll Pane
			ScrollPane scrollPane = new ScrollPane();
			scrollPane.setContent(templateTextArea);
			scrollPane.setPrefHeight(1500);
			scrollPane.setPrefWidth(600);
			scrollPane.setFitToHeight(true);
		
		//Template Pane
			VBox templateWorkoutList = new VBox();
			templateWorkoutList.getChildren().addAll(btCatalystStarter, btBack);
		
			HBox templatePane = new HBox();
			templatePane.getChildren().addAll(templateWorkoutList, scrollPane);
		
			Scene templateScene = new Scene(templatePane, 700, 600);
		
	//Daily work out page
		//Panes
			BorderPane workoutPane = new BorderPane();
			HBox workoutInfoHB = new HBox();
			VBox workoutInfoVB = new VBox();
			VBox workoutInsertVB = new VBox();
			VBox nextWorkoutVB = new VBox();
			VBox rightButtonsVB = new VBox();
		//	HBox labelHBTop = new HBox();
		
		//Buttons
			Button btNextWorkout = new Button();
				btNextWorkout.setText("Next Workout");
				
			Button btPrevWorkout = new Button();
				btPrevWorkout.setText("Previous Workout");
				nextWorkoutVB.getChildren().addAll(btNextWorkout, btPrevWorkout);
				
			Button btBack2 = new Button();
				btBack2.setText("Home Screen");
				workoutPane.setBottom(btBack2);
			
			Button btSaveWorkout = new Button();
				btSaveWorkout.setText("Save Set");
				
			Button btCreateWorkout = new Button();
				btCreateWorkout.setText("Create Workout");

				
			Button btViewWorkout = new Button();
				btViewWorkout.setText("View Past Workout");
				rightButtonsVB.getChildren().addAll(btCreateWorkout, btViewWorkout);

			
		//Labels
			Label lastWorkoutLabel = new Label ("Numbers from Last Time");
			Label todaysWorkoutLabel = new Label ("Today's Workout");
			Label DailyWorkoutTitle = new Label("Workout of the Day");
				DailyWorkoutTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
				workoutPane.setTop(DailyWorkoutTitle);
				workoutPane.setAlignment(DailyWorkoutTitle, Pos.CENTER);
			
			Label workoutNumberLabel = new Label("Workout Number");
			Label dateLabel = new Label("Date (yyyy-mm-dd)");
			Label exerciseLabel = new Label("Exercise");
			Label setNumberLabel = new Label("Set Number");
			Label repLabel = new Label("Rep Amount");
			Label weightLabel = new Label("Weight");
			
		//Exercise Combo Box
			ObservableList<String> exerciseComboList = FXCollections.observableArrayList(
				"Back Squat", "Bench Press", "Overhead Press", "Deadlift", "Clean & Jerk", 
				"Clean Pull", "Snatch", "Snatch Pull", "Front Squat", "Power Snatch", "Power Clean & Power Jerk", 
				"Overhead Squat", "Power Clean", "Hang Clean");
			
			ComboBox exerciseCombo = new ComboBox(exerciseComboList);
				exerciseCombo.setPromptText("Select Exercise");
				
				
			
		//TextAreas
			TextArea dailyWorkoutText = new TextArea();
			dailyWorkoutText.setPrefHeight(250);
			dailyWorkoutText.setPrefWidth(250);
			dailyWorkoutText.setMaxHeight(100);
				workoutInfoVB.getChildren().addAll(todaysWorkoutLabel ,dailyWorkoutText);
				
			TextArea lastWorkoutText = new TextArea();
			lastWorkoutText.setPrefHeight(250);
			lastWorkoutText.setPrefWidth(250);
				workoutInfoVB.getChildren().addAll(lastWorkoutLabel, lastWorkoutText);
				
			TextArea workoutNumberText = new TextArea();
				workoutNumberText.setPrefHeight(10);
				workoutNumberText.setPrefWidth(15);
			TextArea dateText = new TextArea();
				dateText.setPrefHeight(10);
				dateText.setPrefWidth(15);
			TextArea setNumberText = new TextArea();
				setNumberText.setPrefHeight(10);
				setNumberText.setPrefWidth(15);
			TextArea repAmountText = new TextArea();
				repAmountText.setPrefHeight(10);
				repAmountText.setPrefWidth(15);
			TextArea weightText = new TextArea();
				weightText.setPrefHeight(10);
				weightText.setPrefWidth(15);
			
			workoutInsertVB.getChildren().addAll(workoutNumberLabel, workoutNumberText, dateLabel, dateText, 
					exerciseLabel, exerciseCombo, setNumberLabel, setNumberText, repLabel, repAmountText,
					weightLabel, weightText, btSaveWorkout);
			workoutInsertVB.setSpacing(10);
		
		//Set Scene		
			workoutInfoHB.setSpacing(25);
			workoutInfoHB.getChildren().addAll(workoutInfoVB, workoutInsertVB);
			workoutInfoHB.setPadding(new Insets(10, 0, 0, 10));
			workoutPane.setLeft(nextWorkoutVB);
			rightButtonsVB.setPadding(new Insets(10, 10, 10, 10));
			workoutPane.setRight(rightButtonsVB);
			workoutPane.setCenter(workoutInfoHB);
			workoutPane.setAlignment(workoutInfoHB, Pos.BOTTOM_LEFT);
			
			
			Scene dailyWorkoutScene = new Scene(workoutPane, 600, 600);
		
	//Exercise Description
			//Panes
				BorderPane ExerciseDescriptionPane = new BorderPane();
				HBox ExerciseDescriptionHBox = new HBox();
					ExerciseDescriptionHBox.setAlignment(Pos.CENTER); 
				HBox ExerciseDescriptionLabelsHB = new HBox();
				
			//Video Player - Use Media class instead?
				WebView videoPlayer = new WebView();
					videoPlayer.setPrefSize(462, 240);
			
			//Labels
				Label exerciseListLabel = new Label("Exercise List");
					exerciseListLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
				Label exerciseDescriptionLabel = new Label("Exercise Description");
					exerciseDescriptionLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
				Label exerciseVideoLabel = new Label("Exercise Video");
					exerciseVideoLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
				Region r1 = new Region();
					r1.setPrefWidth(60);
				Region r2 = new Region();
					r2.setPrefWidth(160);
				ExerciseDescriptionLabelsHB.getChildren().addAll(exerciseListLabel, r1, exerciseDescriptionLabel, 
						r2, exerciseVideoLabel );
				//ExerciseDescriptionLabelsHB.setHgrow(r1, Priority.ALWAYS);
				//ExerciseDescriptionLabelsHB.setHgrow(r2, Priority.ALWAYS);
				
			//Buttons
				Button btBack3 = new Button();
					btBack3.setText("Home Screen");
				
			//Text Area for Descriptions
				TextArea exerciseDescriptionText = new TextArea();
					exerciseDescriptionText.setPrefHeight(250);
					exerciseDescriptionText.setPrefWidth(400);
					exerciseDescriptionText.setWrapText(true);
				
			//List View
				ListView<String> ExerciseList = new ListView<String>();
				ObservableList<String> ExerciseforLV = FXCollections.observableArrayList (
						"Back Squat", "Front Squat", "Overhead Squat", "Bench Press", "Deadlift", "Overhead Press", "Clean & Jerk",
						"Clean Pull", "Power Clean", "Hang Clean", "Snatch", "Snatch Pull", "Power Snatch");
				ExerciseList.setItems(ExerciseforLV);
					ExerciseList.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle (MouseEvent arg0) {
							exerciseDescriptionText.clear();
							if(ExerciseList.getSelectionModel().getSelectedIndex() == 0) {
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Back Squat"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Back Squat"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						
							else if(ExerciseList.getSelectionModel().getSelectedIndex() == 1){
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Front Squat"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Front Squat"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						
							else if(ExerciseList.getSelectionModel().getSelectedIndex() == 2) {
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Overhead Squat"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Overhead Squat"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}	
						
							else if(ExerciseList.getSelectionModel().getSelectedIndex() == 3) {
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Bench Press"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Bench Press"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						
							else if(ExerciseList.getSelectionModel().getSelectedIndex() == 4) {
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Deadlift"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Deadlift"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
							else if(ExerciseList.getSelectionModel().getSelectedIndex() == 5) {
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Overhead Press"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Overhead Press"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
							else if(ExerciseList.getSelectionModel().getSelectedIndex() == 6) {
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Clean & Jerk"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Clean & Jerk"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
							else if(ExerciseList.getSelectionModel().getSelectedIndex() == 7) {
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Clean Pull"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Clean Pull"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
							else if(ExerciseList.getSelectionModel().getSelectedIndex() == 8) {
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Power Clean"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Power Clean"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
							else if(ExerciseList.getSelectionModel().getSelectedIndex() == 9) {
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Hang Clean"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Hang Clean"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
							else if(ExerciseList.getSelectionModel().getSelectedIndex() == 10) {
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Snatch"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Snatch"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
							else if(ExerciseList.getSelectionModel().getSelectedIndex() == 11) {
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Snatch Pull"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Snatch Pull"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
							else if(ExerciseList.getSelectionModel().getSelectedIndex() == 12) {
								try {
									videoPlayer.getEngine().load(UpdateExercise.getVideo("Power Snatch"));
									exerciseDescriptionText.setText(UpdateExercise.getExerciseDescription("Power Snatch"));
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}						
						}
					});
				
			ExerciseDescriptionPane.setBottom(btBack3);
				ExerciseDescriptionPane.setAlignment(btBack3, Pos.BOTTOM_LEFT);
				ExerciseDescriptionHBox.getChildren().addAll(ExerciseList, exerciseDescriptionText, videoPlayer);
			ExerciseDescriptionPane.setCenter(ExerciseDescriptionHBox);
			ExerciseDescriptionPane.setTop(ExerciseDescriptionLabelsHB);
			Scene exerciseDescriptionScene = new Scene(ExerciseDescriptionPane, 800, 600);
			
	//Button Actions
			btEnter.setOnAction( e -> {
				primaryStage.setScene(homeScene);
			});
			
			btBack.setOnAction( e -> {
				primaryStage.setScene(homeScene);
			});
			
			btBack2.setOnAction( e -> {
				primaryStage.setScene(homeScene);
			});
			
			btBack3.setOnAction( e -> {
				videoPlayer.getEngine().load(null);
				primaryStage.setScene(homeScene);
			});
		
			btProgramTemplate.setOnAction( e -> {
				primaryStage.setScene(templateScene);
			});
			
			btCatalystStarter.setOnAction( e -> {
				templateTextArea.clear();
				templateTextArea.setText(catStart.toString());
			});
			
			btDailyWorkout.setOnAction( e -> {
				primaryStage.setScene(dailyWorkoutScene);
			});
		
			btNextWorkout.setOnAction( e-> {
				dailyWorkoutText.clear();
				dailyWorkoutText.setText(catStart.getNextWorkout());
			});
			
			btPrevWorkout.setOnAction( e-> {
				dailyWorkoutText.clear();
				dailyWorkoutText.setText(catStart.getPrevWorkout());
			});
			btWorkoutDescription.setOnAction(e -> {
				primaryStage.setScene(exerciseDescriptionScene);
			});
	
			btSaveWorkout.setOnAction( e -> {
				int setNumber = Integer.parseInt(setNumberText.getText());
				int Repetitions = Integer.parseInt(repAmountText.getText());
				int Weight = Integer.parseInt(weightText.getText());
					String exerciseTxt = (String) exerciseCombo.getValue();	
				int exerciseID = UpdateSet.getExerciseID(exerciseTxt);
					String Datetxt = dateText.getText();
				int workoutID = 0;
				try {
					workoutID = UpdateSet.getWorkoutID(Datetxt);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					UpdateSet.addSet(exerciseID, setNumber, Repetitions, Weight, workoutID);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				setNumberText.clear();

			});
	
			btCreateWorkout.setOnAction( e -> {
				int workoutNum = Integer.parseInt(workoutNumberText.getText());
				String date = dateText.getText();
				
				try {
					UpdateSet.createWorkout(workoutNum, date);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//dateText.clear();
				workoutNumberText.clear();
			
			});
	
			btViewWorkout.setOnAction( e -> {
				int workoutNum = Integer.parseInt(workoutNumberText.getText());
				try {
					lastWorkoutText.setText(UpdateSet.retrieveSet(workoutNum));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			});
	
}
	
	
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
