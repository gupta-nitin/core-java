

public class MainApp2{

	public static void main(String[] args){
		Student stud_obj_1 = new Student();
		stud_obj_1.setName("abc");
		stud_obj_1.setRollNo(101);
		System.out.println("Student Object 1 - "+ stud_obj_1.hashCode());
		
		Student stud_obj_2 = new Student();
		stud_obj_2.setName("abc");
		stud_obj_2.setRollNo(101);
		System.out.println("Student Object 2 - "+ stud_obj_2.hashCode());
		
	}

	public static void main(){
	}
}