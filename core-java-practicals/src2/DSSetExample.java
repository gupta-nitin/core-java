import java.util.TreeSet;

class DSSetExample
	{
		public static void main(String args[])
			{
				
		        TreeSet<Student> ts=new TreeSet<Student>();
		        ts.add(new Student(101,"ABC"));
		        ts.add(new Student(102,"ABC"));
		        ts.add(new Student(103,"ABC"));
		        ts.add(new Student(103,"ABC"));
		        System.out.println("The elements available in the Tree set are "+ts);
				
				}
		}
