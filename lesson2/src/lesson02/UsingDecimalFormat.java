package lesson02;

import java.text.DecimalFormat;

public class UsingDecimalFormat {

	public static void main(String[] args) {

		DecimalFormat percent = new DecimalFormat("0.00%");

		System.out.println(percent.format(0.308));

		DecimalFormat eNotation1 = new DecimalFormat("0.###E0");// 1 or 2 digits before point

		DecimalFormat eNotation2 = new DecimalFormat("00.###E0");// 2 digits before point

		System.out.println(eNotation1.format(123.456));
		System.out.println(eNotation2.format(123.456));

		double smallNumber = 0.0000123456;

		System.out.println(eNotation1.format(smallNumber));
		System.out.println(eNotation2.format(smallNumber));
	}

}
