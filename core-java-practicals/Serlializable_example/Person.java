
import java.io.*;

public abstract class Person implements Serializable{
	
	private String name;
	
	Person(String name){
		this.name = name;
		System.out.println("Person constructor called");
	}
	
				
	Person(){
		this.name = "";
		System.out.println("Person constructor called");
	}
	

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
}