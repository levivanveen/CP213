package lesson02;

import java.util.Scanner;

public class FormatedOutput {

	public static void salePrice() {

		double salePrice = 199.99;
		String name = "Android phone";
		System.out.printf("$%6.2f for each %s.", salePrice, name);
		System.out.println();
		System.out.println("is an excellent price");

	}
	
	public static void salePriceWithBreakLine() {

		double salePrice = 199.99;
		String name = "Android phone";
		System.out.printf("$%6.2f for each %s. %n", salePrice, name);
		System.out.println();
		System.out.println("is an excellent price");

	}
	
	
	public static void MoneyFormat() {

		double salePrice = 1199.99;
		String name = "Android phone";
		System.out.printf("$%.2f for each %s.", salePrice, name);
		System.out.println();
		System.out.println("is an expensive price");

	}
	

	public static void justifyOutput() {

		double stockPrice = 12.123;
		System.out.printf("Start of the day%8.2fEnd of the day", stockPrice);
		System.out.println();
		System.out.printf("Start of teh day%-8.2fEnd of the day", stockPrice);
		System.out.println();
	}

	public static void main(String args[]) {

		double yourBill = 39.99;
		System.out.printf(" your total for today is $%6.2f", yourBill);
		System.out.println();

		justifyOutput();
		salePrice();
		salePriceWithBreakLine();
	//MoneyFormat () ; 
		
		
		
//		String answer = ""; 
//		String input = ""; 
//		boolean done = false; 
//		Scanner keyboard = new Scanner (System.in) ; 
//
//		while(!done){ 
//		System.out.print("Next word: "); 
//		input = keyboard.next(); 
//		done = input.equals("quit"); 
//		answer += done ? "" : input; 
//		}

	}
}
