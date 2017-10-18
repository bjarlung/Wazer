package com.wazer.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PostViewer extends VBox{
	private List<Button> buttonList;
	public final static int POST_BUTTON_WIDTH = 400;
	public final static int POST_BUTTON_HEIGHT = POST_BUTTON_WIDTH/5;
	
	public PostViewer() {
		buttonList = new LinkedList<>();
		for(int i=0; i<5; i++) {
			addPost("Post");
		}
	}
	
	private void addPost(String postHeader) {
		PostButton button = new PostButton(postHeader, POST_BUTTON_WIDTH, POST_BUTTON_HEIGHT);
		buttonList.add(button);
		this.getChildren().add(button);
	}
	
	public void updatePostList(List<String> posts) {
		clearPostView();
		for (String postHeader : posts) {
			addPost(postHeader);
		}
	}
	
	private void clearPostView() {
		buttonList.clear();
		this.getChildren().clear();
	}

}
