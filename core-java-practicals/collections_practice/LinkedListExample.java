import java.util.*;

class LinkedListExample
   {

   public static void main(String args[])
   {
		List<String>  l1=new  LinkedList<String>();
             //l1.add("a");
              //l1.add("b");
             //l1.add("c");
            // l1.add("d");
        System.out.println(l1);
             //l1.addLast("e");
             //l1.addFirst("k");
            System.out.println(l1);
            if(!l1.isEmpty()){
			l1.removeFirst();
           System.out.println(l1);
            l1.removeLast();
            System.out.println(l1);
			}else {
				System.out.println("Empty");
			}
      }
	  
	  
		public void printList(List<String> listObj){
			System.out.println(listObj);
		}
 }
 
