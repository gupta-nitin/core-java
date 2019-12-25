interface xyz_A{
	abstract public void funx();
}

abstract class abs implements xyz_A //xyz_A is interface
{

    void funy()
    {
      System.out.println("funy() of abstract class abs");
    }
}

class ademo2 extends abs
{
	void funa()
	{
		System.out.println("funa() of class ademo2");
	}
	
	public void funx()
    {
       System.out.println("funx() of abstract class abs");
    }
	
	public static void main(String args[])
	  {
	     xyz_A x1=new ademo2();
	     x1.funx();
	     
	     abs a1=new ademo2();
	     a1.funy();
	  }
       }


