package com.data.entry.ds;

import java.io.Serializable;

/**
 * This class will hold student information for student-data-entry app
 * 
 * @author Nitin
 *
 */
public class Student implements Serializable{
	
	private String name;
	private int age ;
	private long contact;
	private Gender gender;
	private String address;
	
	
	public Student(String name, int age, long contact, Gender gender, String address){
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.gender = gender;
		this.address = address;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setContact(long contact){
		this.contact = contact;
	}
	
	public long getContact(){
		return this.contact;
	}

	public void  setGender(Gender gender){
		this.gender = gender;
	}
	
	public Gender getGender(){
		return this.gender;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return this.address;
	}

}

