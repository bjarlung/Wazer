package com.wazer.view;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;

public class BoardLabel extends Label {
	private int longitude;
	private int latitude;
	private boolean isActive;
	
	public BoardLabel(int latitude, int longitude, int labelSize) {
		this.longitude = longitude;
		this.latitude = latitude;
		isActive = false;
		this.setPrefSize(labelSize, labelSize);
		
		this.setStyle("-fx-background-color: green;");
		//this.setStyle("-fx-border-color: black;");
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
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
