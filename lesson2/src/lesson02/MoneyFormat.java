package lesson02;

import java.text.NumberFormat;
import java.util.Locale;

public class MoneyFormat {
	public static NumberFormat moneyFormatter;

	public static void print() {

		System.out.println(moneyFormatter.format(39.8));
		System.out.println(moneyFormatter.format(39.81111));
		System.out.println(moneyFormatter.format(39.89999));
		System.out.println(moneyFormatter.format(39));
		System.out.println(moneyFormatter.format(39.33333));
		System.out.println();

	}

	public static void main(String[] args) {

		System.out.println("Default location:");
		moneyFormatter = NumberFormat.getCurrencyInstance();
		print();
		System.out.println("English location:");
		moneyFormatter = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
		print();
		
		System.out.println("GERMANY location:");
		moneyFormatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
		print();
		

	}

}