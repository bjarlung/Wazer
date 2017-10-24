package com.wazer.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DisplayBox extends Stage{
	
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
