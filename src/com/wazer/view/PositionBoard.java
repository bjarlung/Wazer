package com.wazer.view;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PositionBoard extends Application{
	public static final int lONG_LAT_POSITIONS = 5;
	public static final int SCENE_SIZE = 600;
	public static final int BOARD_SIZE = 500;
	private Button quitButton;

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Board");
		
		quitButton = new Button("Quit");
		quitButton.setOnAction(e -> primaryStage.close());
		BorderPane layout = new BorderPane();
		layout.setRight(quitButton);
		BorderPane.setAlignment(quitButton, Pos.BOTTOM_CENTER);
		
		//Setting up board
		VBox boardLabelBox = new VBox();
		layout.setCenter(boardLabelBox);
		boardLabelBox.setPadding(new Insets(20));
		
		int labelSize = BOARD_SIZE/lONG_LAT_POSITIONS;
		for(int i = 0; i < lONG_LAT_POSITIONS; i++) {
			HBox hbox = new HBox();
			boardLabelBox.getChildren().add(hbox);
			for(int j = 0; j < lONG_LAT_POSITIONS; j++) {		
				BoardLabel label = new BoardLabel(i, j);
				label.setText(i + "," + j);
				label.setPrefSize(labelSize, labelSize);
				label.setStyle("-fx-border-color: black;");
				hbox.getChildren().add(label);			
			}
		}
		
		//adding scene and showing stage
		Scene scene = new Scene(layout, 600, 600);	
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
