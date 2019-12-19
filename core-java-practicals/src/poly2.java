class poly2
{
void fun1(long x)
{
System.out.println("accept only long value");
}
/*void fun1(int x)
{
System.out.println("fun1 accept only int value");
 
}*/
void fun1(float x,float y)
{
System.out.println("fun1 accept only float value");

}
public static void main(String args[])
{
poly2 p2=new poly2();
p2.fun1(10);
}
}

