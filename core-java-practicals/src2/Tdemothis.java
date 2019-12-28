public class Tdemothis{

public int a,b;

Tdemothis(int b){
	this();
	this.b = b;
}

Tdemothis(){
this.a = 10;
this.b=10;
}

// public void setData(int c, int d){
public void setData(int a, int b){
this.a=a; // a = c;
this.b=b; // b= d;
}

public void showData(){
System.out.println("Value of A is " +a);
System.out.println("Value of B is " +b);
}

public static void main(String args[]){

Tdemothis tdemo = new Tdemothis();
tdemo.setData(2,3);
tdemo.showData();
}

}