package com.wazer.view;

import javafx.scene.control.Button;

public class PostButton extends Button{
	private String header;
	
	public PostButton(String header, int width, int height) {
		this.header = header;
		this.setPrefSize(width, height);
		this.setText(header);
	}
	
	public void setPostText(String header) {
		this.header = header;
		this.setText(header);
	}

}
