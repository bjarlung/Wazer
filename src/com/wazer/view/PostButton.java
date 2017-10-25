package com.wazer.view;

import javafx.scene.control.Button;

/**
 * <h1> PostButton </h1>
 * Extends Button.
 * Represents a post in view, setting style.
 * @author Beatrice
 *
 */
public class PostButton extends Button{
	
	public PostButton(String header, int width, int height) {
		this.setPrefSize(width, height);
		this.setText(header);
	}
	
	public void setPostText(String header) {
		this.setText(header);
	}

}
