import java.util.*;
import java.util.Map.Entry;


public class HashMapExample{ 

	public static void main(String[] args){
		Map<Integer, String> map_obj= new HashMap<Integer, String>();
		map_obj.put(1, "A");
		map_obj.put(2, "B");
		map_obj.put(2, "c");
		map_obj.put(2, "D");
		String oldValue = map_obj.put(2, "E");
		
		System.out.println("old value :"+oldValue);
		System.out.println("Map Object : " + map_obj);
		
		if(map_obj.containsKey(4)){
			System.out.println("Key Found");
		}else{
			System.out.println("Key Not Found");
		}
		
				//Iterating Map
		for(Entry<Integer, String> entry: map_obj.entrySet()){
			System.out.println("Key - " + entry.getKey() );
			System.out.println("Value -" + entry.getValue());
		}
			
	}

}