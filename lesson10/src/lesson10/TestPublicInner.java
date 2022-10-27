package lesson10;

public class TestPublicInner {

	public static void main(String args[]) {
		OuterA a = new OuterA();
		OuterA.InnerB innerb = a.new InnerB();
		innerb.print();
		innerb.callOuterPrint2(); 
	}
	
	
	strictfp class A{}//strictfp applied on class  
	strictfp interface M{}//strictfp applied on interface  
	class B{  
	strictfp void m(){}//strictfp applied on method  
	}  
}
