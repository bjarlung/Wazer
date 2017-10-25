package com.wazer.model;

/**
 * <h1> TypeRepository Interface </h1>
 * Interface determining interaction between program and database
 * @author Beatrice
 *
 */
public interface TypeRepository {
	SubjectType requestType(int primaryKey);
	int createType(String typeName);
	boolean editType(int typeId, String nameNew);
	boolean deleteType(int primaryKey);
}
