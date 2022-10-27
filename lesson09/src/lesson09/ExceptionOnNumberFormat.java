package lesson09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionOnNumberFormat {

	

		public static void main(String[] args) {

			Scanner keyboard = new Scanner(System.in);
			int number = 0; // to keep compiler happy

			boolean done = false;

			while (!done) {
				try {
					System.out.println("Enter a whole number:");
					number = keyboard.nextInt();
					done = true;
				} catch (InputMismatchException e) {
					keyboard.nextLine();
					System.out.println("Not a correctly written whole number.");
					System.out.println("Try again.");
				}
			}

			System.out.println("You entered " + number);
		}
	}
