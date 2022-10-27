package lesson07;

public class Circle extends Shape {

	@Override
	public double area(double radius) {

		return (Math.PI * Math.pow(radius, 2));

	}
}
