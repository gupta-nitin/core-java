 
import java.util.*; 
class HashTabledemo { 
    public static void main(String[] arg) 
    { 
       
        Hashtable<Integer, String> h = 
                      new Hashtable<Integer, String>(); 
  
        Hashtable<Integer, String> h1 = 
                      new Hashtable<Integer, String>(); 
  
        h.put(3, “ABC"); 
        h.put(2, “XYZ"); 
        h.put(1, “PQR”); 

        // checking hash table h 
        System.out.println(“Hashtable - ” + h); 
    } 
} 
