final class Fdemo2
{
	void fun1()
	{
	System.out.println("Call from Final fun1()");
	}
}

class Fdemo3 extends Fdemo2
{
	void fun1()
	{
	System.out.println("Call from Normal fun1()");
	}

	public static void main(String args[])
	{
	  Fdemo3 obj=new Fdemo3();
	  obj.fun1();
	}
   }
