package com.wazer.view;


import com.wazer.WazerMain;
import com.wazer.model.Position;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class PositionView implements View{

	public static final int SCENE_HEIGHT = 600;
	public static final int SCENE_WIDTH = 900;

	private Button quitButton;
	private PostViewer postViewer; 
	private Board board;
	private BorderPane layout;
	private ChangeListener<Boolean> changeListener;
	private Stage primaryStage;
	Scene scene;

	public PositionView(Stage primaryStage, ChangeListener<Boolean> changeListener) {
		this.changeListener = changeListener;
		this.primaryStage = primaryStage;
		initView();		
	}

	private void initView() {
		quitButton = new Button("Quit");	
		postViewer = new PostViewer();
		board = new Board();

		layout = new BorderPane();
		layout.setRight(postViewer);
		layout.setBottom(quitButton);
		BorderPane.setAlignment(quitButton, Pos.BOTTOM_CENTER);	
		layout.setCenter(board);

		//adding scene and showing stage
		scene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);
		
		board.setLocalListener(scene);
		setBoardListener(changeListener);
		
		primaryStage.setTitle("Board");

		primaryStage.setScene(scene);
		primaryStage.show();	
	}

	@Override
	public void setBoardListener(ChangeListener<Boolean> listener) {
		board.setExternalListener(listener);
		quitButton.setOnAction(e -> {
			WazerMain.getPrimaryStageView().hide();
		});
	}

	@Override
	public void updatePostList() {
		System.out.println("Updating");	
		postViewer.updatePostList();		
	}

	@Override
	public Position getCurrentPosition() {
		System.out.println("Position in posView, getCurrPoss" +board.getActiveLabel().getPosition());
		Position position = board.getActiveLabel().getPosition();		
		return position;
	}

	public Board getBoard() {
		return board;
	}
	
	



}
