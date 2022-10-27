package lesson08;


public class TestClassTypes {

public static void main(String args[]) {

		ClassTypeA a = new ClassTypeA();
		ClassTypeB b = new ClassTypeB();
		ClassTypeC c = new ClassTypeC();

		
		a = b; //  1
		a = c; //  2
		b = c;  // 3

		
//		b = a;  // 4
//		c = a ; // 5
//		c = b ; // 6
		
		b = (ClassTypeB) a;  // 7
		c = (ClassTypeC) a ; // 8
		c = (ClassTypeC)b ;  // 9
		
	//	c = (ClassTypeA)b ; // 10
	}
}
