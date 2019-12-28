import java.io.*;
class FoutTest {
   
   public static void main(String args[]){

    try{

		FileOutputStream fout=new FileOutputStream("studentdata.txt");
		String s="Hello";

		byte b[]=s.getBytes();	

		fout.write(b);

		fout.close();

		System.out.println("success");

  }

  catch(Exception e){

		System.out.println(e);

    }
  }
 }


