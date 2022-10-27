package lesson02;

import java.util.Scanner;

public class ReadUserInput {

	public static void terminatorIssue() {
		System.out.println("enter an int and two lines");
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		keyboard.nextLine();
		String line1 = keyboard.nextLine();
		String line2 = keyboard.nextLine();

		System.out.println(" n is " + n);
		System.out.println(" line1 is " + line1);
		System.out.println(" line2 is " + line2);
	}

	public static void getUserInput() {
		Scanner input = new Scanner(System.in);
		System.out.println("please enter two words separated  by space");
		String string1 = input.next();
		String string2 = input.next();

		System.out.println("string1 is " + string1 + " and string2 is " + string2);

	}

	public static void changeDelimter() {
		Scanner input = new Scanner(System.in);
		input.useDelimiter("stop");
		System.out.println(" enter words, end is used as deliminter ");

		String s = input.next();
		System.out.println(s);

	}

	public static void useDelimterAndString() {
		Scanner input = new Scanner("Hello/CP213/Class");
		input.useDelimiter("/");
			while (input.hasNext()) {
			String s = input.next();

			System.out.println(s);
		}
	}

	public static void main(String args[]) {

		// getUserInput() ;
		// terminatorIssue() ;
		//changeDelimter();
		useDelimterAndString() ; 
		
	}
}
