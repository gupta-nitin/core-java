interface xyz
{
	public void funx();
	public void funy();

}

class X 
{
	public void funA()
	{
	  System.out.println("funA() of class x");
	}
	
 }


class Y extends X implements xyz{
	
	public void funx()
	{
	  System.out.println("funx() of class Y");
	}
	

	public void funy()
	{
	System.out.println("funy() of class y");
	}
	
	public void funA()
	{
	  System.out.println("funA() of class y");
	}
	
	public static void main(String args[])
	{
	  Y y1=new Y();
	  y1.funx();
	  y1.funy();
	  y1.funA();
	}
}