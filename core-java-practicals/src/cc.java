class cc
{
	protected void funcc()
	{
	  System.out.println("funcc of class cc");
	}
}
class bb extends cc
{
	public void funcc()
	{
		
	 System.out.println("funcc of class bb");
		super.funcc();
	}
}
class  aa  extends bb
{
	void funaa()
	{
	  System.out.println(" funaa of class aa");
	}
	
	public static void main(String[] args)
	{
	  aa aaa=new aa();
	  aaa.funcc();
	  aaa.funaa();
	}
}
