package com.wazer.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.wazer.model.Post;
import com.wazer.model.UserUtil;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PostViewer extends VBox{
	private List<PostButton> buttonList;
	public final static int POST_BUTTON_WIDTH = 400;
	public final static int POST_BUTTON_HEIGHT = POST_BUTTON_WIDTH/5;

	public PostViewer() {
		buttonList = new ArrayList<>();
	}

	private void addPost(String postHeader, String idAsString) {
		PostButton button = new PostButton(postHeader, POST_BUTTON_WIDTH, POST_BUTTON_HEIGHT);
		button.setId(idAsString);
		buttonList.add(button);
		this.getChildren().add(button);
	}

	public void updatePostList() {
		clearPostView();
		List<Post> postList = UserUtil.getActiveUser().getPostList();
		for (Post post : postList) {
			String header = post.getHeader();
			String idAsString = Integer.toString(post.getPostId());
			addPost(header, idAsString);
		}
	}

	private void clearPostView() {
		buttonList.clear();
		this.getChildren().clear();
	}

}
