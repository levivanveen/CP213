package lesson10;

public class C implements A, B {

//	public int getX() {
//		// return (A.x) ;
//		// return (B.x);
//	}

	public static void main(String args[]) {

		System.out.println(A.x == B.x);
	}
}
