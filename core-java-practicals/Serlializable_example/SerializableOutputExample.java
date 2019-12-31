import java.io.*;

class SerializableOutputExample{

	public static void main(String[] args){
		
		Student  stud_obj= new Student(101,"ABC");
		
		try(FileOutputStream fout = new FileOutputStream("Object_Output.ser");
				ObjectOutputStream obj_out= new ObjectOutputStream(fout);){
		obj_out.writeObject(stud_obj);
		}catch(Exception e){
			e.printStackTrace();	
		}
		
	}


}