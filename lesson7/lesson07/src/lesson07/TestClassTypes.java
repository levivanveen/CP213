package lesson07;

public class TestClassTypes {

public static void main(String args[]) {

		ClassTypeA a = new ClassTypeA();
		ClassTypeB b = new ClassTypeB();
		ClassTypeC c = new ClassTypeC();

		// These are allowed
		a = b; //  1
		a = c; //  2
		b = c;  // 3

		// the below statements cause errors. remove the comments and test the code.
//		b = a;  // 4
//		c = a ; // 5
//		c = b ; // 			
	}
}
