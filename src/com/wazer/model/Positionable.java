package com.wazer.model;

/**
 * <h1> Interface Positionable </h1>
 * Implemented by User, Post and BoardLabel.
 * @author Beatrice
 *
 */
public interface Positionable {
	Position getPosition();
	void setPosition(int latitude, int longitude);
}
