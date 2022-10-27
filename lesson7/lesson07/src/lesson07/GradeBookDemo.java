package lesson07; 
public class GradeBookDemo {
	public static void main(String[] args) {
		GradeBook book = new GradeBook();
		book.display();

		double [][] a; 
		a = new double[3][];
		//Since the above line does not specify the size of 
		//a[0], a[1], or a[2], each could be made a different size instead:
		a[0] = new double[5];
		a[1] = new double[10];
		a[2] = new double[4];

	}
}
