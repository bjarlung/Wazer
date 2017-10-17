package com.wazer.model;

import java.util.ArrayList;
import java.util.List;

public class SubjectType {
	
	private int typeId; 
	private String typeName;
	private List<Post> postList;
	
	public SubjectType() {
		postList = new ArrayList<>();
	}
		
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public List<Post> getPostList() {
		return postList;
	}

	
	
}
