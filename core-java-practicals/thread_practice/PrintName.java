class PrintName implements Runnable {
	String name;
	PrintName(String name){
		this.name=name;
	}

	public void run(){
          for(int i=0;i<5;i++){
          System.out.println(name);
         }
     }
   }
    
class MainApp4{
       public static void main(String args[]){
       
	   PrintName pn=new PrintName("A");
	   
	   Thread t1=new Thread(pn);
       t1.start();
	   //t1.run() // will not act as thread 
	   //pn.run() // will not act as thread
    }
}

