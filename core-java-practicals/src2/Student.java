

public class Student extends Person{

	private int rollNo;
		
	public int getRollNo(){
		return rollNo;
	}
	
	public void setRollNo(int rollNo){
		this.rollNo = rollNo;
	}
	
	public void printName(){
	
	System.out.println(getName());
		
	}
	
	public int hashCode(){
		return rollNo;
	}

}
