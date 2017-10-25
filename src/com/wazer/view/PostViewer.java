package com.wazer.view;

import java.util.ArrayList;
import java.util.List;

import com.wazer.model.Post;
import com.wazer.model.UserUtil;
import javafx.scene.layout.VBox;

/**
 * <h1> PostViewer </h1>
 * Extends VBox.
 * Displays all posts on specific location in shape of PostButtons
 * @author Beatrice
 *
 */
public class PostViewer extends VBox{
	private List<PostButton> buttonList;
	public final static int POST_BUTTON_WIDTH = 350;
	public final static int POST_BUTTON_HEIGHT = POST_BUTTON_WIDTH/5;

	public PostViewer() {
		buttonList = new ArrayList<>();
	}
	
	/**
	 * Creates new PostButton objects according to input. Sets them to the PostViewer.
	 * @param postHeader
	 * @param idAsString
	 * @param content
	 */
	private void addPost(String postHeader, String idAsString, String content) {
		PostButton button = new PostButton(postHeader, POST_BUTTON_WIDTH, POST_BUTTON_HEIGHT);
		button.setId(idAsString);
		buttonList.add(button);
		this.getChildren().add(button);
		button.setOnAction(e -> new DisplayBox(postHeader, content));
	}
	
	/**
	 * Clears postViewer and gets new list of posts from activeUser. Updates viewer accordingly.
	 */
	public void updatePostList() {
		clearPostView();
		List<Post> postList = UserUtil.getActiveUser().getPostList();
		for (Post post : postList) {
			String header = post.getHeader();
			String idAsString = Integer.toString(post.getPostId());
			String content = post.getContent();
			addPost(header, idAsString, content);
		}
	}

	private void clearPostView() {
		buttonList.clear();
		this.getChildren().clear();
	}

}
