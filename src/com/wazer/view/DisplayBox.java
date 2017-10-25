package com.wazer.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <h1> DisplayBox </h1>
 * Extends Stage
 * Pop up window that displays chosen post
 * @author Beatrice
 *
 */
public class DisplayBox extends Stage{
	/**
	 * Creates components, sets style of window. Shows until closed.
	 * @param header
	 * @param content
	 */
	public DisplayBox(String header, String content) {
		super();
		this.initModality(Modality.APPLICATION_MODAL);
		this.setTitle(header);
		this.setMinWidth(350);
		this.setMinHeight(200);
		
		Label contentLabel = new Label(content);
		Button closeButton = new Button("close");
		closeButton.setOnAction(e -> this.close());
		
		VBox layout = new VBox();
		layout.getChildren().addAll(contentLabel, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		this.setScene(scene);
		this.showAndWait();
	}

}
