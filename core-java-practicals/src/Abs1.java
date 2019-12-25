public abstract class Abs1
{
	int i,j;
	abstract void funA();
	
	void funB()
	{
	  System.out.println("funb()");
	}
}

class Ademo1 extends Abs1
{
	public void funA()
	{
	  System.out.println("funa() of class Ademo1");
	}
	
	void fun1()
	{
	  System.out.println("fun1()");
	}
	public static void main(String args[])
	{
	 
	  Abs1 d1=new Ademo1();
	  System.out.println(d1.i);
	  System.out.println(d1.j);
	  d1.funB();
	  d1.funA();
	  //d1.fun1();
	}
}
