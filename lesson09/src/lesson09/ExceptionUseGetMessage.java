package lesson09;

import java.util.Scanner;

public class ExceptionUseGetMessage extends Exception {

	public ExceptionUseGetMessage() {
		super(" Exception Use GetMessage");
	}

	public ExceptionUseGetMessage(String msg) {
		super(msg);
	}

	public static void main(String[] args) {
		try {
			Scanner keyboard = new Scanner(System.in);

			System.out.println("Enter numerator:");
			int numerator = keyboard.nextInt();
			System.out.println("Enter denominator:");
			int denominator = keyboard.nextInt();

			if (denominator == 0)
				throw new ExceptionUseGetMessage("my personal error message");

			double quotient = numerator / (double) denominator;
			System.out.println(numerator + "/" + denominator + " = " + quotient);
		} catch (ExceptionUseGetMessage e) {

			System.out.println(" 1 e.toString() prints " + e.toString());
			System.out.println(" 2 e.getClass) prints " + e.getClass());
			System.out.println(" 3 e.getMessage() prints " + e.getMessage());
			System.out.println(" 4 printStackTrace prints");
			e.printStackTrace();
		}

		System.out.println("End of program.");
	}

}
