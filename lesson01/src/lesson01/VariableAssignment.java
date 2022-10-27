package lesson01;

public class VariableAssignment {
	public static void main(String args[]) {

		int x = 2;
		double y;

		y = x; // this is possible
		// x = y; // this is a mismatch error cannot assignment double to int

		x = (int) y; // explicit type casting

		byte b;
		short s;

	//	s = b; // correct
		// b = s; // mismatch type

//		s = x; // mismatch type
//		b = x; // mismatch type

//		x = b; // correct assignment
//		x = s; // correct assignment

		long l;
		// x = l; // mismatch type
		l = x;

		double d;
		float f;

		d = l;
//		l = d; // mismatch type

		f = l;
		// l = f; // mismatch type

		char c = 'a';
		char a = 98;
		int charvalue = (int) c;

		boolean bool1 = true;
		boolean bool2 = false;

//		bool1 = 0; // type mismatch cannot convert from int to boolean
//		bool2 = 1; // type mismatch cannot convert from int to boolean

		// bool1 = (boolean) 1; // cannot cast from int to boolean

	}

}
