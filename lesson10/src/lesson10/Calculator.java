package lesson10;

public class Calculator implements AddingString{
	
	private int number1, number2 ; 
	
	public String add (String st1, String st2) {
		
		 number1 =  Integer.valueOf(st1) ; 
		
		 number2 =  Integer.valueOf(st2) ; 
		Integer result = number1 + number1 ; 
		 return (result.toString()) ; 		
	}
}
