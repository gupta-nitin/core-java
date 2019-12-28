class A extends Thread
{
  public void run()
  {
    for(int i=1;i<=5;i++)
    {
      System.out.println("\t From Thread A : i = "+i);
    }
    System.out.println("Exit from A");
  }
}



class B extends Thread
{
  public void run()
  {
    for(int j=1;j<=5;j++)
    {
      System.out.println("\t From Thread B : j = "+j);
    }
    System.out.println("Exit from B");
  }
}

class MainApp5{
       public static void main(String args[]){
        A a1=new A();
        a1.start();

        B b1=new B();
        b1.start();
      }
 }

