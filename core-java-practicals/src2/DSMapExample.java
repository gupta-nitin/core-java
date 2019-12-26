import java.util.*;

class DSMapExample
	{
		public static void main(String args[])
			{
				
		        Map<Student, Integer> ts=new HashMap<Student, Integer>();
		        
				Student temp_Stud_obj = new Student(101,"ABC"); 
				ts.put(temp_Stud_obj,temp_Stud_obj.hashCode());
				
				temp_Stud_obj = new Student(102,"ABC");
		        ts.put(temp_Stud_obj, temp_Stud_obj.hashCode());
				
				temp_Stud_obj = new Student(103,"ABC");
				ts.put(temp_Stud_obj,temp_Stud_obj.hashCode());
				
				temp_Stud_obj = new Student(104,"ABC");
				ts.put(temp_Stud_obj,temp_Stud_obj.hashCode());
				
				
				temp_Stud_obj = new Student(103,"jkl");
				ts.put(temp_Stud_obj,temp_Stud_obj.hashCode());
				
				
		        System.out.println("The elements available in the MAp are "+ ts);
				
				}
		}

/* 
{RollNo = 101, Name = ABC=101, 
RollNo = 102, Name = ABC=102, 
RollNo = 103, Name = ABC=103,
 RollNo = 103, Name = jkl=103, 
 RollNo = 104, Name = ABC=104}
 
 -------------------------
 {RollNo = 101, Name = ABC=101,
 RollNo = 102, Name = ABC=102, 
 RollNo = 103, Name = ABC=103,
 RollNo = 104, Name = ABC=104}

*/