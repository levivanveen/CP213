package lesson07;

public class Square extends Shape {

	@Override
	public double area(double... dimentions) {
		double area = 0.0;
			area = (dimentions[0] * dimentions[1]);
		return area;
	}
}
