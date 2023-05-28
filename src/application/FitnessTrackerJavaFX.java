package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FitnessTrackerJavaFX extends Application{
	
	private int time;
	private int activityFlag=0;
	Activity swimming = new Activity();
	Activity running = new Activity();
	Activity kickBoxing = new Activity();
	Activity strengthTraining = new Activity();
		
	Activity heartRateTotal = new Activity();
	
	private int totalCalories;
	private double totalHeartRate=80.0;
	
	private double swimmingOldActivityHeartRate;
	private double swimmingNewActivityHeartRate;
	private double runningOldActivityHeartRate;
	private double runningNewActivityHeartRate;
	private double kickBoxingOldActivityHeartRate;
	private double kickBoxingNewActivityHeartRate;
	private double strengthTrainingOldActivityHeartRate;
	private double strengthTrainingNewActivityHeartRate;

	
	DecimalFormat df = new DecimalFormat("0.000");

	Activity[] Activity = new Activity[4];
	
			
	public static void main(String[] args)
	{
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		
		//Window for Results//
		
		//Initialization:
		
		Stage secondStage = new Stage();
	    secondStage.setTitle("Results");
	    secondStage.setX(900);
	    secondStage.setY(200);
	    secondStage.setResizable(false);
		Pane secondRoot = new Pane();
		secondRoot.setStyle("-fx-background-color: #0000FF"); //BLUE color
		Scene secondScene = new Scene(secondRoot,600,400);
		secondStage.setScene(secondScene);
        secondStage.show();
		
		        
        //Labels
        
        Label Results = new Label("Results");
		Results.setFont(new Font("Arial Bold", 25));
		Results.setLayoutX(250);
		Results.setLayoutY(20);
		Results.setTextFill(Color.web("#FF0000", 1)); //Red color
        
        Label totalCaloriesTitle= new Label("Total Calories Burnt: ");
		totalCaloriesTitle.setFont(new Font("Arial Bold", 20));
		totalCaloriesTitle.setLayoutX(40);
		totalCaloriesTitle.setLayoutY(100);
		totalCaloriesTitle.setTextFill(Color.web("#FFFF00", 1)); //Yellow color
        
        Label totalCaloriesText = new Label("0  calories");
		totalCaloriesText.setFont(new Font("Arial Bold", 20));
		totalCaloriesText.setLayoutX(250);
		totalCaloriesText.setLayoutY(100);
		totalCaloriesText.setTextFill(Color.web("#98FB98", 1)); //Pale Green color
		
        Label totalHeartRateTitle= new Label("Total Heart Rate: ");
		totalHeartRateTitle.setFont(new Font("Arial Bold", 20));
		totalHeartRateTitle.setLayoutX(40);
		totalHeartRateTitle.setLayoutY(250);
		totalHeartRateTitle.setTextFill(Color.web("#FFFF00", 1)); //Yellow color
        
        Label totalHeartRateText = new Label("80  beat/minute");
		totalHeartRateText.setFont(new Font("Arial Bold", 20));
		totalHeartRateText.setLayoutX(230);
		totalHeartRateText.setLayoutY(250);
		totalHeartRateText.setTextFill(Color.web("#98FB98", 1)); //Pale Green color
		
		
		secondRoot.getChildren().addAll(totalCaloriesText,totalCaloriesTitle,Results,totalHeartRateTitle,totalHeartRateText); //Adding Labels
		
		
		//Window for Activities Rank//
		
		//Initialization
		
		Stage thirdStage = new Stage();
	    thirdStage.setTitle("Activities Rank");
	    thirdStage.setX(900);
	    thirdStage.setY(200);
	    thirdStage.setResizable(false);
		Pane thirdRoot = new Pane();
		thirdRoot.setStyle("-fx-background-color: #FFC0CB"); //Pink color
		Scene thirdScene = new Scene(thirdRoot,600,400);
		thirdStage.setScene(thirdScene);
        
        
        //Labels and Buttons
        
        Label rankTitle = new Label("Activities Rank");
		rankTitle.setFont(new Font("Arial Bold", 25));
		rankTitle.setLayoutX(200);
		rankTitle.setLayoutY(20);
		rankTitle.setTextFill(Color.web("#FF0000", 1)); //Red color
		
		Button Close = new Button("Return to Total Results");
		Close.setLayoutX(215);
		Close.setLayoutY(350);
		Close.setFont(new Font("Arial Bold", 15));
		Close.setOnAction(e -> { 
		    secondStage.setX(900);
		    secondStage.setY(200);
			thirdStage.hide();
			secondStage.show();
		});
		
		Label First = new Label("#1");
		First.setFont(new Font("Arial Bold", 20));
		First.setLayoutX(20);
		First.setLayoutY(100);
		First.setTextFill(Color.web("#FF0000", 1)); //Red color
		
		Label Second = new Label("#2");
		Second.setFont(new Font("Arial Bold", 20));
		Second.setLayoutX(20);
		Second.setLayoutY(150);
		Second.setTextFill(Color.web("#FF0000", 1)); //Red color
		
		Label Third = new Label("#3");
		Third.setFont(new Font("Arial Bold", 20));
		Third.setLayoutX(20);
		Third.setLayoutY(200);
		Third.setTextFill(Color.web("#FF0000", 1)); //Red color
		
		Label Fourth = new Label("#4");
		Fourth.setFont(new Font("Arial Bold", 20));
		Fourth.setLayoutX(20);
		Fourth.setLayoutY(250);
		Fourth.setTextFill(Color.web("#FF0000", 1)); //Red color
		
		Label N1 = new Label("");
		N1.setFont(new Font("Arial Bold", 20));
		N1.setLayoutX(50);
		N1.setLayoutY(100);
		N1.setTextFill(Color.web("#FF0000", 1)); //Red color
		
		Label N2 = new Label("");
		N2.setFont(new Font("Arial Bold", 20));
		N2.setLayoutX(50);
		N2.setLayoutY(150);
		N2.setTextFill(Color.web("#FF0000", 1)); //Red color
		
		Label N3 = new Label("");
		N3.setFont(new Font("Arial Bold", 20));
		N3.setLayoutX(50);
		N3.setLayoutY(200);
		N3.setTextFill(Color.web("#FF0000", 1)); //Red color
		
		Label N4 = new Label("");
		N4.setFont(new Font("Arial Bold", 20));
		N4.setLayoutX(50);
		N4.setLayoutY(250);
		N4.setTextFill(Color.web("#FF0000", 1)); //Red color
		
		Label N1_Desc = new Label("Empty");
		N1_Desc.setFont(new Font("Arial", 16));
		N1_Desc.setLayoutX(230);
		N1_Desc.setLayoutY(100);
		N1_Desc.setTextFill(Color.web("#000000", 1)); //Black color
		
		Label N2_Desc = new Label("Empty");
		N2_Desc.setFont(new Font("Arial", 16));
		N2_Desc.setLayoutX(230);
		N2_Desc.setLayoutY(150);
		N2_Desc.setTextFill(Color.web("#000000", 1)); //Black color
		
		Label N3_Desc = new Label("Empty");
		N3_Desc.setFont(new Font("Arial", 16));
		N3_Desc.setLayoutX(230);
		N3_Desc.setLayoutY(200);
		N3_Desc.setTextFill(Color.web("#000000", 1)); //Black color
		
		Label N4_Desc = new Label("Empty");
		N4_Desc.setFont(new Font("Arial", 16));
		N4_Desc.setLayoutX(230);
		N4_Desc.setLayoutY(250);
		N4_Desc.setTextFill(Color.web("#000000", 1)); //Black color
		     
		
		thirdRoot.getChildren().addAll(rankTitle,Close,N1,N2,N3,N4,N1_Desc,N2_Desc,N3_Desc,N4_Desc,First,Second,Third,Fourth); //Adding Labels and Buttons

		
		//Window for INPUT//
		
		//Initialization:
		
	    primaryStage.setTitle("Fitness Tracker");
	    primaryStage.setX(200);
	    primaryStage.setY(200);
		primaryStage.setResizable(false);
		Pane root = new Pane();
		root.setStyle("-fx-background-color: #00FFFF"); //CYAN color
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		//Buttons and Labels:
		
		//Labels
		Label title = new Label("Fitness Tracker");
		title.setFont(new Font("Arial Bold", 20));
		title.setLayoutX(230);
		title.setTextFill(Color.web("#FF0000", 1)); //Red color
		
		Label Description = new Label("Keep Track of your Calories and Heart Rate");
		Description.setLayoutX(180);
		Description.setLayoutY(25);
		Description.setFont(new Font("Arial", 14));
		
		Label select = new Label("Select an Activity: ");
		select.setTextFill(Color.web("#FF0000", 1)); //Red color
		select.setLayoutX(40);
		select.setLayoutY(65);
		select.setFont(new Font("Arial Bold", 18));
		
		Label enterTime = new Label("Enter time in minutes: ");
		enterTime.setTextFill(Color.web("#9400D3", 1)); //Purple color
		enterTime.setLayoutX(40);
		enterTime.setLayoutY(160);
		enterTime.setFont(new Font("Arial Bold", 18));
		
		Label invalidTime = new Label("");
		invalidTime.setTextFill(Color.web("#FF0000", 1)); //Red color
		invalidTime.setLayoutX(260);
		invalidTime.setLayoutY(206);
		invalidTime.setFont(new Font("Arial Bold", 15));
		
		Label noSelection = new Label("");
		noSelection.setTextFill(Color.web("#FF0000", 1)); //Red color
		noSelection.setLayoutX(260);
		noSelection.setLayoutY(110);
		noSelection.setFont(new Font("Arial Bold", 15));
		
		
		//TextField
		TextField timevalue = new TextField();
		timevalue.setPromptText("Enter time in minutes...");
		timevalue.setLayoutX(40);
		timevalue.setLayoutY(200);
		

		//ComboBox
		String activities[] = { "Swimming", "Running", "Kick Boxing", "Strength Training" };
		ComboBox activitiesSelection = new ComboBox(FXCollections.observableArrayList(activities));
		activitiesSelection.setPromptText("---Select an Activity---");
		activitiesSelection.setLayoutX(40);
		activitiesSelection.setLayoutY(100);
				
		
		//ADD Button
		Button addBtn = new Button("Add Activity");
		addBtn.setLayoutX(250);
		addBtn.setLayoutY(260);
		addBtn.setStyle("-fx-background-color: #FFFF00"); //Yellow color
		addBtn.setFont(new Font("Arial Bold", 15));
		
		
		//Make actions on clicking the ADD Button
		addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	if(activitiesSelection.getSelectionModel().getSelectedIndex() == 0)
            	{
            		noSelection.setText("");
            		activityFlag=1;
            	}
            	else if(activitiesSelection.getSelectionModel().getSelectedIndex() == 1)
            		{
            			noSelection.setText("");
            			activityFlag=2;
            		}
            	else if(activitiesSelection.getSelectionModel().getSelectedIndex() == 2)
            		{
            			noSelection.setText("");
            			activityFlag=3;
            		}
            	else if(activitiesSelection.getSelectionModel().getSelectedIndex() == 3)
            		{
            			noSelection.setText("");
            			activityFlag=4;
            		}
            	else if(activitiesSelection.getSelectionModel().getSelectedIndex() == -1)
            		noSelection.setText("Select an Activity !");

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setX(300);
				alert.setY(400);
				alert.setContentText("Activity added successfully !");
				alert.setHeaderText(null);
				alert.setTitle(null);
            	
        		time = Integer.parseInt(timevalue.getText());


        		if (time>=0)
        		{
        			
        			invalidTime.setText("");

        			if(activityFlag==1)
        			{
        				swimming.setCalories(swimming.newCalories(4,time));
        				swimmingOldActivityHeartRate=totalHeartRate;
	        			heartRateTotal.setHeartRate(totalHeartRate + ( totalHeartRate * 0.002 * time ));
	        			totalHeartRate=heartRateTotal.getHeartRate();
	        			swimmingNewActivityHeartRate= swimmingNewActivityHeartRate + (totalHeartRate-swimmingOldActivityHeartRate);	
	        			swimming.setSingleActivityHeartRate(swimmingNewActivityHeartRate);
        				alert.show();

        			}
        			else if(activityFlag==2)
        			{
        				running.setCalories(running.newCalories(5,time));
        				runningOldActivityHeartRate=totalHeartRate;
        				heartRateTotal.setHeartRate(totalHeartRate + ( totalHeartRate * 0.003 * time ));
	        			totalHeartRate=heartRateTotal.getHeartRate();
	        			runningNewActivityHeartRate= runningNewActivityHeartRate + (totalHeartRate-runningOldActivityHeartRate);
	        			running.setSingleActivityHeartRate(runningNewActivityHeartRate);
        				alert.show();

        			}
        			else if(activityFlag==3)
        			{
        				kickBoxing.setCalories(kickBoxing.newCalories(3,time));
        				kickBoxingOldActivityHeartRate=totalHeartRate;
	        			heartRateTotal.setHeartRate(totalHeartRate + ( totalHeartRate * 0.005 * time ));
	        			totalHeartRate=heartRateTotal.getHeartRate();
	        			kickBoxingNewActivityHeartRate=kickBoxingNewActivityHeartRate + (totalHeartRate-kickBoxingOldActivityHeartRate); 			
	        			kickBoxing.setSingleActivityHeartRate(kickBoxingNewActivityHeartRate);
        				alert.show();

        			}
        			else if(activityFlag==4)
        			{
        				strengthTraining.setCalories(strengthTraining.newCalories(5,time));
        				strengthTrainingOldActivityHeartRate=totalHeartRate;
	        			heartRateTotal.setHeartRate(totalHeartRate + ( totalHeartRate * 0.006 * time ));
	        			totalHeartRate=heartRateTotal.getHeartRate();
	        			strengthTrainingNewActivityHeartRate= strengthTrainingNewActivityHeartRate + (totalHeartRate-strengthTrainingOldActivityHeartRate);
	        			strengthTraining.setSingleActivityHeartRate(strengthTrainingNewActivityHeartRate);
        				alert.show();

        			}


        			totalCalories= swimming.getCalories()+running.getCalories()+kickBoxing.getCalories()+strengthTraining.getCalories();   
        			
        			if (activityFlag != 0)
        			{
        			totalCaloriesText.setText(""+totalCalories + "  calories");
    				totalHeartRateText.setText(""+df.format(totalHeartRate) + "  beat/minute");
        			}
        			
        			
        			//For the Activities Rank Window
        			
        			Activity[0] = swimming;
        			Activity[1] = running;
        			Activity[2] = kickBoxing;
        			Activity[3] = strengthTraining;
        			
        			
        			for (int i = 0; i < Activity.length; i++)
        		    {
        		        for (int j = 0; j < Activity.length; j++)
        		        {
        		            if (Activity[i].getCalories() >= Activity[j].getCalories())
        		            {
        		                Activity temp = Activity[i];
        		                Activity[i] = Activity[j];
        		                Activity[j] = temp;
        		            }
        		        }
        		    }
        			
        			for (int i = 0; i < Activity.length; i++)
        		    {
        		        for (int j = 0; j < Activity.length; j++)
        		        {
        		            if (Activity[i].getSingleActivityHeartRate() >= Activity[j].getSingleActivityHeartRate() && Activity[i].getCalories() == Activity[j].getCalories())
        		            {
        		                Activity temp = Activity[i];
        		                Activity[i] = Activity[j];
        		                Activity[j] = temp;
        		            }
        		        }
        		    }
        			
        			swimming.setName("Swimming");
        			running.setName("Running");
        			kickBoxing.setName("Kick Boxing");
        			strengthTraining.setName("Strength Training");
        			
        			N1.setText(Activity[0].getName());
        			N2.setText(Activity[1].getName());
        			N3.setText(Activity[2].getName());
        			N4.setText(Activity[3].getName());
        			N1_Desc.setText("Calories= "+Activity[0].getCalories()+"  ,Heart Rate Increase= "+df.format(Activity[0].getSingleActivityHeartRate()));
        			N2_Desc.setText("Calories= "+Activity[1].getCalories()+"  ,Heart Rate Increase= "+df.format(Activity[1].getSingleActivityHeartRate()));
        			N3_Desc.setText("Calories= "+Activity[2].getCalories()+"  ,Heart Rate Increase= "+df.format(Activity[2].getSingleActivityHeartRate()));
        			N4_Desc.setText("Calories= "+Activity[3].getCalories()+"  ,Heart Rate Increase= "+df.format(Activity[3].getSingleActivityHeartRate()));
        			
        			
        		}
        		else
        		{
        			invalidTime.setText("Invalid Time !");
        		}

            }
        });


		//Exit Button
		Button exit = new Button("Exit");
		exit.setLayoutX(500);
		exit.setLayoutY(350);
		exit.setStyle("-fx-background-color: #ADD8E6"); //Light Blue color
		exit.setOnAction(e -> System.exit(0));
		
		
		//Activities Rank Button
		Button activitiesRank = new Button("Activities Rank");
		activitiesRank.setLayoutX(240);
		activitiesRank.setLayoutY(320);
		activitiesRank.setStyle("-fx-background-color: #e75480"); //Dark Pink color
		activitiesRank.setFont(new Font("Arial Bold", 15));
		activitiesRank.setOnAction(e -> {
		    thirdStage.setX(900);
		    thirdStage.setY(200);
			thirdStage.show();
			secondStage.hide();
		});
		
		
		root.getChildren().addAll(addBtn,exit,activitiesSelection,title,Description,select,enterTime,timevalue,activitiesRank,invalidTime,noSelection); //Adding Buttons and Labels   

	
	}

}
