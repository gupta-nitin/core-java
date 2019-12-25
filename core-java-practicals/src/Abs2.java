abstract class Abs2
{
	void fun1()
	{
		System.out.println("fun1() of abstract class abs");
	}
}

class ademo2 extends Abs2
	{
		void funa()
		{
			System.out.println("funa() of class ademo2");
		}
		public static void main(String args[])
			{
				ademo2 d1=new ademo2();
				d1.fun1();
				d1.funa();
	}
  }
