package com.wazer.view;

import java.util.List;

import com.wazer.model.Position;

import javafx.beans.value.ChangeListener;
import javafx.scene.input.MouseEvent;

public interface View {
	void setBoardHandler(ChangeListener<Boolean> handler);
	void updatePostList(List<String> postList);
	Position getCurrentPosition();
}
