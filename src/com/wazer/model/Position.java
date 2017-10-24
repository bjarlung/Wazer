package com.wazer.model;

public class Position {
	private int longitude;
	private int latitude;
	public static final int LATUTUDE_DEFAULT = 2;
	public static final int LONGITUDE_DEFAULT = 3;
	
	public Position() {
		setToDefaults();	
	}

	private void setToDefaults() {
		latitude = LATUTUDE_DEFAULT;
		longitude = LONGITUDE_DEFAULT;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	
	@Override
	public String toString() {
		return latitude + "" + longitude;	
	}
	
}
