import java.util.*;


 class ArrayListIteraorExample
   {

   public static void main(String args[])
   {

		List<String> l1 = new ArrayList<String>();
             l1.add("a");
              l1.add("b");
             l1.add("c");
             l1.add("d");
		
		removeElementsStartingWithA(l1);
			
		
		
		//for(int index =0)
			
			
			/*Iterator it = l1.listIterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}*/
      
	}
	
	public static void removeElementsStartingWithA(List<String> list){
		System.out.println("Before Removing - " + list );
		
		Iterator it = list.listIterator();
			while(it.hasNext()){
				System.out.println("Removing - " + it.next() );
				it.remove();
		}
		
		/*for(String element : list){
				System.out.println("Removing - " + element );
				list.remove(element);
		}*/
		System.out.println("After Removing- " + list );
	}
	 
   }
