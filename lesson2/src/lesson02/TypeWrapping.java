package lesson02;

import java.util.ArrayList;
import java.util.List;

public class TypeWrapping {

	public static int sumOfValues(List<Integer> integerList) {
		int sum = 0;
		for (Integer i : integerList) {
			if (i % 2 == 0)
				sum += i; // integer to int conversion
		}
		return sum;
	}

	public static void main(String args[]) {

		ArrayList<Integer> arrayList = new ArrayList<>();

		for (int i = 1; i < 10; i++) {
			arrayList.add(i); // int to Integer
		}

		ArrayList<Integer> arryList2 = new ArrayList<>();

		for (int i = 1; i < 10; i += 2) {
			arryList2.add(Integer.valueOf(i));
		}

		List<Integer> arryList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {

			arrayList.add(new Integer(i));
		}

		sumOfValues(arrayList);
	
	}
}
