package com.wazer.view;


import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PositionView extends Application{

	public static final int SCENE_HEIGHT = 600;
	public static final int SCENE_WIDTH = 900;

	private Button quitButton;
	private PostViewer postViewer; 


	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Board");
		
		quitButton = new Button("Quit");
		quitButton.setOnAction(e -> primaryStage.close());
		
		postViewer = new PostViewer();

		
		
		BorderPane layout = new BorderPane();
		layout.setRight(postViewer);
		layout.setBottom(quitButton);
		BorderPane.setAlignment(quitButton, Pos.BOTTOM_CENTER);
		
		
		Board board = new Board();
		layout.setCenter(board);
		
		
		//adding scene and showing stage
		Scene scene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);	
		board.setListener(scene);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
