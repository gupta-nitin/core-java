
import java.io.*;

public class DataInputExample {

	public static void main(String args[])   {

   try(  DataInputStream stdin=new DataInputStream(System.in);){

      System.out.println("Enter your Name");

      String s= stdin.readLine();
      System.out.print("Your Name :");

      System.out.println(s);

   }catch(Exception e){
     System.out.println("try again");
   }

 }

}
