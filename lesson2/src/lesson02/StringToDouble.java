package lesson02;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringToDouble {
	
	public static void main (String args []) {
		Scanner keyboard = new Scanner (System.in) ; 
		System.out.println ("please enter two numbers on a line seperated by comma") ; 
		String input = keyboard.nextLine() ; 
		
		StringTokenizer tokens = new StringTokenizer (input, ","); 
		
		String string1 ="" ; 
		String string2 ="" ; 
		
		if (tokens.countTokens() == 2) {
			
			string1 = tokens.nextToken() ; 
			string2 = tokens.nextToken() ; 		
		}else {
			System.out.println (" restart again") ; 
			System.exit(0);
		}
		
		double number1 = Double.parseDouble(string1);
		double number2 = Double.parseDouble(string2); 
		
		System.out.println ("both strings convered to numbers " + number1  + " and " + number2) ; 
	}

}
