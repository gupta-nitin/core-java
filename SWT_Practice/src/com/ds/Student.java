package com.ds;

public class Student {

	private String rollNo;
	private String name;
	
	public Student(String rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}
	
	public String getRollNo(){
		return this.rollNo;
	}
	
	public String getName(){
		return this.name;
	}
	
}
