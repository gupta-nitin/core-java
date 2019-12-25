 import java.util.HashSet;

class HashSetExample
{

public static void main(String args[])
{

  HashSet hs=new HashSet();
  hs.add("D");
  hs.add("A");
  hs.add("C");
  hs.add(new Student());
  hs.add(1);
  hs.add("B");
  System.out.println("The elements available in the hash set are "+hs);
}
}
