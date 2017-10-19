package com.wazer.view;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wazer.model.Position;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PositionView extends Application implements View{

	public static final int SCENE_HEIGHT = 600;
	public static final int SCENE_WIDTH = 900;

	private Button quitButton;
	private PostViewer postViewer; 
	private Board board;

	
	public PositionView() {}
	public PositionView(String[] args) {
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

		board = new Board();
		layout.setCenter(board);

		//adding scene and showing stage
		Scene scene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);	
		board.setLocalListener(scene);

		//TODO flytta till controller	
		setBoardHandler((observable, oldValue, newValue) -> getPostsByPosition());
		

		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	//TODO flytta till controller
	private void getPostsByPosition() {
		BooleanProperty property = board.getActiveChanged();
		if(property.get()) {
			System.out.println("Changed");
		}
		property.set(false);
	}

	@Override
	public void setBoardHandler(ChangeListener<Boolean> handler) {
		board.setExternalHandler(handler);

	}

	@Override
	public void updatePostList(List<String> postList) {
		// TODO Auto-generated method stub

	}

	@Override
	public Position getCurrentPosition() {
		return board.getActiveLabel().getPosition();
	}

}
