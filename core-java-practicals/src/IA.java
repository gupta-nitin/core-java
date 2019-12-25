interface IA{
	public void funA();
}

class B implemnts IA{
	
	public voi funA(){
		System.out.println("FunA of class B");
	}
	
	public void funB(){
		System.out.println("FunA of class B");
	}
	
	public static void main(String[] args){
		IA obj = new B();
		obj.funA();
		((B)obj).funB();
	}

}