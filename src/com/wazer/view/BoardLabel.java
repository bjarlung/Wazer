package com.wazer.view;

import com.wazer.model.Position;
import com.wazer.model.Positionable;

import javafx.scene.control.Label;
/**
 * <h1> BoardLabel </h1>
 * Extends Label.
 * Represents single board box, setting style.
 * @author Beatrice
 *
 */
public class BoardLabel extends Label implements Positionable{
	private Position position;
	private boolean isActive;
	
	public BoardLabel(Position position, int labelSize) {
		this.position = position;

		isActive = false;
		this.setPrefSize(labelSize, labelSize);
		
		this.setStyle("-fx-background-color: green;");
		//this.setStyle("-fx-border-color: black;");
	}

	public boolean isActive() {
		return isActive;
	}

	/**
	 * Sets style depending on whether the board label is activated or not
	 * @param isActive
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
		if(isActive)
			this.setStyle("-fx-background-color: blue;");
		else
			this.setStyle("-fx-background-color: green;");
	}
	
	@Override
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	/**
	 * Not implemented
	 */
	@Override
	public void setPosition(int latitude, int longitude) {
	}
	
	
	
}
