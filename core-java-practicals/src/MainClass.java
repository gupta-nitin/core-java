import com.ds.Student;

public class MainClass{

	public static void main(String args[]){
		
		
	
		Student stud_obj_1 = new Student();
		stud_obj_1.setRoll_no(101);
		
		stud_obj_1.setVa1(10);
		
		Student stud_obj_2 = new Student();
		stud_obj_2.setRoll_no(102);
		
		stud_obj_2.setVa1(20);
	
	
	
	System.out.println("roll no of stud_obj_1 - " + stud_obj_1.getRoll_no());
	System.out.println("var1 of stud_obj_1 - " + stud_obj_1.getVa1());
	System.out.println("----------------------");
	System.out.println("roll no of stud_obj_2 - " + stud_obj_2.getRoll_no());
	System.out.println("var1 of stud_obj_2 - " + stud_obj_1.getVa1());
	System.out.println("----------------------");
	
	}

}