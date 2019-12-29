 import java.io.*;

class SequenceFileTest{
  
  public static void main(String args[]){

  try(FileInputStream fin1=new FileInputStream("input1.txt");
    FileInputStream fin2=new FileInputStream("input2.txt");
    SequenceInputStream sis=new SequenceInputStream(fin1,fin2);){
    
   int i;

	while((i=sis.read())!=-1){
		System.out.print((char)i);
	}

  }catch(Exception e){
		e.printStackTrace();
   }
  }
}
