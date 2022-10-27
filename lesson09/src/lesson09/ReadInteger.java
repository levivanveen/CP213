package lesson09;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ReadInteger {
	
	public static void main(String[] args) {
		int intValue = 0; 
		boolean correct = false;
		
		Scanner keyboard = new Scanner(System.in);
		
		while (!correct) {
			try {
				System.out.println("Enter a Non-fraction  number:");
				intValue = keyboard.nextInt();
				correct = true;
			} catch (InputMismatchException e) {
				keyboard.nextLine();
				
				System.out.print("You entered and incorrect value. " );				
				System.out.println("Please try again \n");
			}
		}
		if (correct)
		System.out.println("You entered " + intValue);
	}
	
	


}
