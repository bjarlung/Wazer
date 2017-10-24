package com.wazer.view;

import java.util.List;

import com.wazer.model.Position;
import com.wazer.model.Post;

import javafx.beans.value.ChangeListener;
import javafx.scene.input.MouseEvent;

public interface View {
	void setBoardListener(ChangeListener<Boolean> listener);
	void updatePostList();
	Position getCurrentPosition();
}
