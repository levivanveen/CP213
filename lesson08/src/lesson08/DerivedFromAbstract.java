package lesson08;

public class DerivedFromAbstract extends MyAbstractClass {

	public void print() {
		System.out.println(" x value is " + x);

	}

	DerivedFromAbstract(int x) {
		super(x);
	}

	public int abstractIsType(MyAbstractClass myAb) {
		return (myAb.x * 10);
	}

	public static void main(String args[]) {

		MyAbstractClass ab = new DerivedFromAbstract(25);
		ab.print();

		DerivedFromAbstract myab = new DerivedFromAbstract(30);

		System.out.println();

		System.out.println(myab.abstractIsType(myab));
	}
}
