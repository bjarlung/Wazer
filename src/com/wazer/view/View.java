package com.wazer.view;

import com.wazer.model.Position;
import javafx.beans.value.ChangeListener;

/**
 * <h1> View Interface </h1>
 * Facade for interaction between GUI and Controller
 * @author Beatrice
 *
 */
public interface View {
	void setBoardListener(ChangeListener<Boolean> listener);
	void updatePostList();
	Position getCurrentPosition();
}
