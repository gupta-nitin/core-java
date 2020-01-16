package com.data.entry.ds;

public enum Gender {

	MALE("Male"),
	FEMALE("Female"),
	OThER("other");
	
	private String value;
	
	Gender(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
