


public abstract class Person{
	
	private String name;
	
	Person(String name){
		this.name = name;
		System.out.prinln("Person constructor called");
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