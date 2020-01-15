package com.data.entry.ds;

public enum ValidationKeys {

	
	ID_ERROR("ID-Error"),
	NAME_ERROR("Name-Error"),
	AGE_ERROR("Age-Error"),
	ADDRESS_ERROR("ADDRESS_ERROR");
	
	String key;
	private ValidationKeys(String key) {
		this.key = key;
	}
	
}
