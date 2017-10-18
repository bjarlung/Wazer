package com.wazer.view;

import javafx.scene.control.Button;

public class PostButton extends Button{
	private String content;
	
	public PostButton(String content, int width, int height) {
		this.content = content;
		this.setPrefSize(width, height);
		this.setText(content);
	}

}
