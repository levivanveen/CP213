package lesson02;

import java.util.Scanner;

public class ReadWithSanner {

	public static void main(String[] args) {
		String tocontinue = "no";

		int number1, number2;
		Scanner keyboard = new Scanner(System.in);

		do {

			System.out.println("Enter two integer numbers");
			System.out.println("seperated by one or more spaces:");

			number1 = keyboard.nextInt();
			number2 = keyboard.nextInt();
			System.out.println("You entered " + number1 + " and " + number2);

			System.out.println("Next enter two double numbers.");
			System.out.println("Decimal points are allowed.");

			double dnumber1, dnumber2;
			dnumber1 = keyboard.nextDouble();
			dnumber2 = keyboard.nextDouble();
			System.out.println("You entered " + dnumber1 + " and " + dnumber2);

			System.out.println("Next enter two strings:");

			String string1 = keyboard.next();
			String string2 = keyboard.next();
			System.out.println("You entered \"" + string1 + "\" and \"" + string2 + "\"");

			String extraSpace = keyboard.nextLine();

			System.out.println("Next enter a line of text:");
			String line = keyboard.nextLine();
			System.out.println("You entered: \"" + line + "\"");

			System.out.println(" do you want to continue? yes/no");
			tocontinue = keyboard.next().toUpperCase();

		} while (tocontinue.equals("YES"));
	}

}
