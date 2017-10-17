package com.wazer.view;

import javafx.scene.control.Label;

public class BoardLabel extends Label {
	private int longitude;
	private int latitude;
	
	public BoardLabel(int longitude, int latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}
	
	
}
