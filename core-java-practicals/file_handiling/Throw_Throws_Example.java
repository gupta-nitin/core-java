import java.util.Scanner;

class Throw_Throws_Example{

	public static void main(String[] args ){
	
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int result = divide(a,b);
		
		System.out.println(result);
	}

	public static int divide (int a, int b) throws ArithmeticException{
		
		int result = 0;

		try{
			result =a/b ;
		}catch(ArithmeticException e){
			throw new ArithmeticException("Value of B shold be greater than Zero");
		}
		return result;
		
	
	}


}