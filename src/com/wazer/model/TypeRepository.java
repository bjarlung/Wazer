package com.wazer.model;

public interface TypeRepository {
	SubjectType requestType(int primaryKey);
	int createType(String typeName);
	boolean editType(int typeId, String nameNew);
	boolean deleteType(int primaryKey);
}
