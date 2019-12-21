class Cdemo1
{
     public static void main(String args[])
     {
           System.out.println(args);//address of object of array of string
           System.out.println(args.length);
           /*for(String s1 : args)
            {
            System.out.println(s1);
           }*/
		   
		   for(int index =0; index < 4;index++){
			System.out.println(args[index]);
		   }
    } 
}
