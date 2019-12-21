class A
{
	int i,j;
	void funA()
	{
	  i=i+1;
	}
}
public class B extends A
{
	int x,y;
	void funB()
	{
	  x=x+1;
   	  i=i+1;
   }

public static void main(String args[])
  	{
	   B b1=new B();
     	   b1.funB();
      	   b1.funA();
   	   System.out.println(b1.x);
	   System.out.println(b1.i);
	}
}
