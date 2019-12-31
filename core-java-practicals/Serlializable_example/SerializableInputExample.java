import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializableInputExample {

	public static void main(String[] args) {

		try (FileInputStream fileInputStream = new FileInputStream("Object_Output.ser");
				ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)){
		
			Student stud = (Student) inputStream.readObject();
			System.out.println("Student Object Retrived " );
			System.out.println("Student Roll No = " + stud.getRollNo() );
			System.out.println("Student Name = " + stud.getName() );
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
