package com.wazer.view;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Board extends StackPane{
	Map<String,BoardLabel> boardMap;
	public static final int BOARD_SIZE = 500;
	public static final int lONG_LAT_POSITIONS = 5;
	VBox boardLabelBox;
	BoardLabel activeLabel;

	public Board() {		
		boardMap = new HashMap<>();
		
		initLabels();		
		activeLabel = boardMap.get("32");
		activeLabel.setActive(true);
		this.getChildren().add(boardLabelBox);
		

	}

	public void setListener(Scene scene) {
		scene.setOnKeyPressed(e -> move(e.getCode()));
	}


	private void move(KeyCode code) {
		boolean isChanged = false;
		int latitude = activeLabel.getLatitude();
		int longitude = activeLabel.getLongitude();
		switch (code) {
		case UP:
			if(latitude > 0) {
				latitude-=1;
				isChanged = true;
			}
			break;
		case DOWN:
			if(latitude < lONG_LAT_POSITIONS-1) {
				latitude+=1;
				isChanged = true;
			}
			break;
		case LEFT:
			if(longitude > 0) {
				longitude-=1;
				isChanged = true;
			}
			break;
		case RIGHT:
			if(longitude < lONG_LAT_POSITIONS-1) {
				longitude+=1;
				isChanged = true;
			}
			break;
		default:
			break;
		}
		
		if(isChanged)
			activateLabel(convertToId(latitude, longitude));		
	}


	private void initLabels() {
		boardLabelBox = new VBox();
		boardLabelBox.setPadding(new Insets(20));
		int labelSize = BOARD_SIZE/lONG_LAT_POSITIONS;
		for(int latitude = 0; latitude < lONG_LAT_POSITIONS; latitude++) {
			HBox hbox = new HBox();
			boardLabelBox.getChildren().add(hbox);
			for(int longitude = 0; longitude < lONG_LAT_POSITIONS; longitude++) {		
				BoardLabel label = new BoardLabel(latitude, longitude, labelSize);			
				hbox.getChildren().add(label);
				String id = convertToId(latitude, longitude);
				label.setId(id);
				label.setText(id);
				boardMap.put(id, label);
			}
		}
	}
	
	private String convertToId(int latitude, int longitude) {
		return latitude + "" + longitude;
	}

	private void activateLabel(String labelId) {
		activeLabel.setActive(false);
		activeLabel = boardMap.get(labelId);
		activeLabel.setActive(true);
	}

}
