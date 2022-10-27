package lesson08;

public class ClassTypeB extends ClassTypeA{
	
 public void test ( ) {
	 ClassTypeB.print () ; 
 }
 
 public static void print () {
	 System.out.println ("B") ; 
 }

	public void newPrint ( ) {
		 System.out.println ( "B") ; 
	 }

 public static void main (String args[]) {
	 ClassTypeB b = new ClassTypeB (); 
	 
	 ClassTypeA a  ; // = new ClassTypeA (); 
	 
	 a = b; 

	 a.newPrint();  // calls newprint from B class and prints B
	 ClassTypeA.print()  ;   // calls print from A, because print is static and prints A
	 
	 // both A and B has test method. 
	 // inside A.test() a static method print is called. however this 
	 // has no impact on call testing from B and not A class. 
	 a.test();
 
 
	}
}


