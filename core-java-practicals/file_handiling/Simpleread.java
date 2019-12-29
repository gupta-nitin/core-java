import java.io.*;

class Simpleread{

    public static void main(String args[]){


   try(FileInputStream fin = new FileInputStream("c:/input.txt")){

		int i;

		while((i=fin.read())!=-1)
			System.out.print((char)i);

	} catch(Exception e){

		System.out.println(e);

	}
	
  }
 }

