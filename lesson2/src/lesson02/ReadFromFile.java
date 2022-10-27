package lesson02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {

	public String fileName;
	public Scanner inputFile = null;

	public void getFileName() {

		System.out.println(" please enter file name with full path");
		try {
			fileName = new Scanner(System.in).next();
			inputFile = new Scanner(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File not found. try again");
			getFileName();
		}
	}

	public static void main(String[] args) {
		ReadFromFile readFileObject = new ReadFromFile();
		readFileObject.getFileName();
		int score;
		String name;

		while (readFileObject.inputFile.hasNextLine()) {
			score = readFileObject.inputFile.nextInt();
			readFileObject.inputFile.nextLine(); 
			name = readFileObject.inputFile.nextLine();
			System.out.println("Name: " + name);
			System.out.println("your score is: " + score);
		}
		readFileObject.inputFile.close();
	}
}
