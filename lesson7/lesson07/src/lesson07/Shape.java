package lesson07;

public class Shape {

	public void print() {
		System.out.println("print shape");
	}
	
	public double area(double radius) {
		return 0; 
	}

	public double area(double... dimentions) {
		double area = 0.0;

		if (dimentions.length == 2) {
			area = (dimentions[0] * dimentions[1]);
		}else {
			// other cases 
		}
		return area;
	}

}
