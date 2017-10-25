package com.wazer.view;

import java.util.HashMap;
import java.util.Map;

import com.wazer.model.Position;
import com.wazer.model.UserUtil;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * <h1> Board </h1>
 * Extends StackPane
 * Puts together the board consisting of boardLabels
 * @author Beatrice
 *
 */
public class Board extends StackPane{
	Map<String, BoardLabel> boardMap;
	public static final int BOARD_SIZE = 500;
	public static final int lONG_LAT_POSITIONS = 5;
	private VBox boardLabelBox;
	private BoardLabel activeLabel;
	private BooleanProperty activeChanged;
	
	/**
	 * Initiates variables. Adds components to board. Gets and adds users position to board.
	 */
	public Board() {		
		boardMap = new HashMap<>();	
		initLabels();		
		this.getChildren().add(boardLabelBox);	
		activeChanged = new SimpleBooleanProperty(false);
		String userPositionAsString = UserUtil.getActiveUser().getPosition().toString();
		activeLabel = boardMap.get(userPositionAsString);
		activeLabel.setActive(true);
	}
	
	/**
	 * Sets key listener to scene
	 * @param scene
	 */
	public void setLocalListener(Scene scene) {
		scene.setOnKeyPressed(e -> move(e.getCode()));
	}

	/**
	 * Handles events from keys.
	 * Changes the active label according to users move
	 * @param code KeyCode
	 */
	private void move(KeyCode code) {
		boolean isChanged = false;
		int latitude = activeLabel.getPosition().getLatitude();
		int longitude = activeLabel.getPosition().getLongitude();
		switch (code) {
		case UP:
			if(longitude > 0) {
				longitude-=1;
				isChanged = true;
			}
			break;
		case DOWN:
			if(longitude < lONG_LAT_POSITIONS-1) {
				longitude+=1;
				isChanged = true;
			}
			break;
		case LEFT:
			if(latitude > 0) {
				latitude-=1;
				isChanged = true;
			}
			break;
		case RIGHT:
			if(latitude < lONG_LAT_POSITIONS-1) {
				latitude+=1;
				isChanged = true;
			}
			break;
		default:
			break;
		}
		
		if(isChanged) {
			activateLabel(convertToId(latitude, longitude));
			activeChanged.set(true);
		}
	}

	/**
	 * Initiates board labels in HBox and VBox, creating board grid.
	 * Sets position for each label
	 */
	private void initLabels() {
		boardLabelBox = new VBox();
		boardLabelBox.setPadding(new Insets(20));
		int labelSize = BOARD_SIZE/lONG_LAT_POSITIONS;
		for(int longitude = 0; longitude < lONG_LAT_POSITIONS; longitude++) {
			HBox hbox = new HBox();
			boardLabelBox.getChildren().add(hbox);
			for(int latitude = 0; latitude < lONG_LAT_POSITIONS; latitude++) {
				Position position = new Position();
				position.setLatitude(latitude);
				position.setLongitude(longitude);
				BoardLabel label = new BoardLabel(position, labelSize);			
				hbox.getChildren().add(label);
				String id = convertToId(latitude, longitude);
				label.setId(id);
				//label.setText(id);
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
	/**
	 * Adds listener to instance variable activeChanged, BooleanProperty 
	 * @param listener
	 */
	public void setExternalListener(ChangeListener<Boolean> listener) {
		activeChanged.addListener(listener);
	}

	public BoardLabel getActiveLabel() {
		return activeLabel;
	}

	public void setActiveChanged(BooleanProperty activeChanged) {
		this.activeChanged = activeChanged;
	}

	public BooleanProperty getActiveChanged() {
		return activeChanged;
	}
	
	


}
