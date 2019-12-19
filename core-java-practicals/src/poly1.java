class poly1
{
	void fun1()
	{
	 System.out.println("fun1");
	}
	
	void fun1(int x)
	{
	System.out.println("fun1(int x) of class poly1");
	}

	void fun1(int x,int y)
	{
	System.out.println("fun1(x,y) of class poly1");
	}

	public static void main(String args[])
	{
	poly1 p1=new poly1();
      	p1.fun1(6);
	}

}
