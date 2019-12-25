import java.util.*;


 class ArrayListExample
   {

   public static void main(String args[])
   {

		ArrayList l1=new ArrayList();
             l1.add("a");
              l1.add("b");
             l1.add("c");
             l1.add("d");
			System.out.println("size of array -"+l1.size());
			System.out.println(l1);
            
            l1.add(2,"e");
            System.out.println(l1);
			l1.remove(3);
			 l1.add("a");
			  l1.add("a");
			   l1.add("a");
			System.out.println(l1);
			
			
		List list2 = new ArrayList();
	
            l1.removeAll(list2);
            System.out.println(l1);
      }
   }
