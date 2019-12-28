class MyThread extends Thread{
    public void run(){                 
		System.out.println("MyThread start");
		try{
			System.out.println("MyThread sleep for 1000 ms");
			sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("MyThread finsihed");
	}
}

class MyThread2 extends Thread{
    public void run(){                 
		System.out.println("Thread 2 start");
		System.out.println("Executing some statements");
		System.out.println("Thread 2 Finished");
	}
}



class MainApp3{
	
	public static void main(String args[]){
        MyThread m1= new MyThread();
        m1.run(); 
		
		MyThread2 m2= new MyThread2();
        m2.run();
		
		System.out.println("Finished");

    }

}