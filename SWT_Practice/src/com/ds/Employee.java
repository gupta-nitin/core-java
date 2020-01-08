package com.ds;

public class Employee {

	private String id;
	private String name;
	
	public Employee(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
}
