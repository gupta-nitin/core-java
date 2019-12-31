class ExceptionExample{

	public static void main(String[] args){
		try{
		int number = Integer.parseInt(args[0]);
		int dvidedBy = Integer.parseInt(args[1]);
		int result = number/dvidedBy;
		System.out.println(result);
		}catch(ArithmeticException exeception){
			System.out.println("Divide By Zero is not supported or invalid operation. [Second Argument should be greater than Zero]");
		}catch(ArrayIndexOutOfBoundsException exeception2 ){
			System.out.println("Please provide two arguments");
		}catch(NumberFormatException exeception3 ){
			System.out.println("Arguments can only be Numbers");
		}
		finally{
			System.out.println("Thanks for using this app...");
		}
		System.out.println("Program Terminited normally...");
	}
	
}