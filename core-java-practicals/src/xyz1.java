			interface xyz1
			{
			     public void funx();
			}
			class IdemoA  implements xyz1
			{
			     public void funx()
			     {
			          System.out.println("funx() of class IdemoA");
			     }
				 
				 public void funA()
			     {
			          System.out.println("funA() of class IdemoA");
			     }
				 
			     public static void main(String args[])
			     {
			          IdemoA x1 = new IdemoA();
			          x1.funx();
					  x1.funA();
		       	     }
			}
