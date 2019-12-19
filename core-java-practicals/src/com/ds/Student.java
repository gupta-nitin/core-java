package com.ds;

public class Student{
	
	static int var1;
	int roll_no;
	
	
	public Student(){
		System.out.println("constructor got executed and ");
	}
	
/*	public Student(int roll_no_args){
		System.out.println("constructor got executed and "+roll_no_args+" is assigned");
	}
	
	/*Student(int roll_no_args){
		roll_no = roll_no_args;
	}*/
		
	public void setRoll_no(int roll_no){
		this.roll_no = roll_no;
	}
	
	public int getRoll_no(){
		return roll_no;
	}
	
	public static int getVa1(){
		return var1;
	}
	
	public static void setVa1(int val1_arg){
		var1 = val1_arg;
	}

}