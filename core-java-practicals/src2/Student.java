

public class Student  extends Person{

	private int rollNo;
		
		
	public Student(int rollNo, String name){
			this.rollNo=rollNo;
			setName(name);
	}
	
	public int getRollNo(){
		return rollNo;
	}
	
	public void setRollNo(int rollNo){
		this.rollNo = rollNo;
	}
	
	public void printName(){
	
	System.out.println(getName());
		
	}
	
	public String toString(){
	
	return "RollNo = "+ rollNo + ", Name = "+getName(); 
		
	}
	
	public boolean equals(Object obj){
		return rollNo == ((Student)obj).getRollNo();
	}
	
	public int hashCode(){
		return rollNo;
	}

}
