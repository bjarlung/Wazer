package com.wazer.view;

import com.wazer.WazerMain;
import com.wazer.model.Position;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

/**
 * <h1> PositionView </h1>
 * Implements View interface.
 * Represents the game window, with board and post viewer.
 * @author Beatrice
 *
 */
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
	/**
	 * Constructor. Initiates scene showing stage
	 * @param primaryStage
	 * @param changeListener
	 */
	public PositionView(Stage primaryStage, ChangeListener<Boolean> changeListener) {
		this.changeListener = changeListener;
		this.primaryStage = primaryStage;
		initView();		
	}

	/**
	 * Setting up scene with components, adding listeners, showing stage.
	 */
	private void initView() {
		quitButton = new Button("Quit");	
		postViewer = new PostViewer();
		board = new Board();

		layout = new BorderPane();
		layout.setRight(postViewer);
		layout.setBottom(quitButton);
		BorderPane.setAlignment(quitButton, Pos.BOTTOM_CENTER);	
		layout.setCenter(board);

		scene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);
		
		board.setLocalListener(scene);
		setBoardListener(changeListener);
		
		primaryStage.setTitle("Board");

		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
	/**
	 * Sets changeListener to board. Closes primaryStage on quit button.
	 */
	@Override
	public void setBoardListener(ChangeListener<Boolean> listener) {
		board.setExternalListener(listener);
		quitButton.setOnAction(e -> {
			WazerMain.getPrimaryStageView().hide();
		});
	}

	@Override
	public void updatePostList() {
		postViewer.updatePostList();		
	}

	@Override
	public Position getCurrentPosition() {
		Position position = board.getActiveLabel().getPosition();		
		return position;
	}

	public Board getBoard() {
		return board;
	}
	
	



}
