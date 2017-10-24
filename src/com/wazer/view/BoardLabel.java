package com.wazer.view;

import com.wazer.model.Position;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;

public class BoardLabel extends Label {
	private Position position;
	private boolean isActive;
	
	public BoardLabel(Position position, int labelSize) {
		this.position = position;

		isActive = false;
		this.setPrefSize(labelSize, labelSize);
		
		this.setStyle("-fx-background-color: green;");
		//this.setStyle("-fx-border-color: black;");
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
		if(isActive)
			this.setStyle("-fx-background-color: blue;");
		else
			this.setStyle("-fx-background-color: green;");
	}
	
	
	
}
