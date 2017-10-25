package com.wazer.controller;

import java.util.List;

import com.wazer.model.Position;
import com.wazer.model.Post;
import com.wazer.model.PostRepository;
import com.wazer.model.PostRepositoryJDBC;
import com.wazer.model.User;
import com.wazer.model.UserUtil;
import com.wazer.view.PositionView;

import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

/**
 * <h1> ViewController </h1>
 * Controls interaction between View and post database
 * @author Beatrice
 *
 */
public class ViewController {
	private PostRepository postRepo;
	private PositionView view;
	
	/**
	 * Creates instance variables and calls to update view according to database
	 * @param primaryStage
	 */
	public ViewController(Stage primaryStage) {
		postRepo = new PostRepositoryJDBC();
		view = new PositionView(primaryStage, getChangeListener());
		updateViewPosts();
	}
	
	/**
	 * Creates change listener that updates view from post database
	 * @return
	 */
	private ChangeListener<Boolean> getChangeListener(){
		ChangeListener<Boolean> listener = new ChangeListener<Boolean>() {		
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				updateViewPosts();
			}
		};
		return listener;
	}
	
	/**
	 * Updates view with database posts if the user has moved to a new position
	 */
	public void updateViewPosts() {
		BooleanProperty property = view.getBoard().getActiveChanged();
		if(property.get()) {
			Position position = view.getCurrentPosition();
			User activeUser = UserUtil.getActiveUser();
			activeUser.setPosition(position.getLatitude(), position.getLongitude());
			List<Post> postList = postRepo.requestPostByPosition(position);
			activeUser.setPostList(postList);
			view.updatePostList();
			property.set(false);
		}	
	}

}
