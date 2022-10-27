package cp213;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author David Brown
 * @version 2021-09-24
 */
public class A02Main {
    public static final String SEPARATOR = "-".repeat(40);

    /**
     * Test
     *
     * @param args unused
     */
    public static void main(final String[] args) {
	System.out.println("Assignment 2 Methods Tests");
	System.out.println();
	testFood();
    }

    public static void testFood() {
	System.out.println("List of origins:");
	System.out.println(Food.originsMenu());
	System.out.println(SEPARATOR);
	System.out.println("New Food Object:");
	Food food = new Food("Lasagna", 7, false, 135);
	System.out.println(food);
	System.out.println(SEPARATOR);
	testFoodCompareTo();
	System.out.println(SEPARATOR);
	System.out.println("Comparisons");
	System.out
	.println("Compare Lasagna to itself: " + food.compareTo(food));
	final Food first = new Food("aaa", 0, false, 0);
	final Food last = new Food("zzz", 11, false, 0);
	System.out.println("First Food:");
	System.out.println(first);
	System.out.println("Compare Lasagna to aaa: " + food.compareTo(first));
	System.out.println("Last Food:");
	System.out.println(last);
	System.out.println("Compare Lasagna to zzz: " + food.compareTo(last));
	System.out.println(SEPARATOR);
	System.out.println("Getters for Lasagna");
	System.out.println("Name: " + food.getName());
	System.out.println("Origin (int): " + food.getOrigin());
	System.out.println("Origin (String): " + food.getOriginString());
	System.out.println("Vegetarian: " + food.isVegetarian());
	System.out.println("Calories: " + food.getCalories());
	System.out.println(SEPARATOR);
	System.out.println("Read Foods from file:");
	ArrayList<Food> foods = null;
	try {
	    final File file = new File("foods.txt");
	    Scanner fileIn = new Scanner(file);
	    foods = FoodUtilities.readFoods(fileIn);
	    fileIn.close();
	} catch (FileNotFoundException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	for (final Food f : foods) {
	    System.out.println(f);
	}
	System.out.println(SEPARATOR);
	System.out.println("readFood from string");
	String line = "lasagna|7|false|135";
	food = FoodUtilities.readFood(line);
	System.out.println(food);
	System.out.println(SEPARATOR);
	System.out.println("Average Calories of All Foods");
	System.out.println(FoodUtilities.averageCalories(foods));
	System.out.println(SEPARATOR);
	System.out.println("Average Calories of Italian Foods");
	System.out.println(FoodUtilities.averageCaloriesByOrigin(foods, 7));
	System.out.println(SEPARATOR);
	System.out.println("List of Vegetarian Foods");
	ArrayList<Food> veggie = FoodUtilities.getVegetarian(foods);

	for (final Food f : veggie) {
	    System.out.println(f);
	}
	System.out.println(SEPARATOR);
	System.out.println("List of Italian Foods");
	ArrayList<Food> italian = FoodUtilities.getByOrigin(foods, 7);

	for (final Food f : italian) {
	    System.out.println(f);
	}
	System.out.println(SEPARATOR);
	System.out.println("Searching");
	System.out.println(
		"Search for Vegetarian Italian foods under 300 calories");
	System.out.println("Search: 7, 300, true");
	final ArrayList<Food> someFoods = FoodUtilities.foodSearch(foods, 7, 300, true);

	System.out.println(SEPARATOR);

	for (final Food f : someFoods) {
	    System.out.println(f);
	}
	try {
	    File outFile = new File("newFoods.txt");
	    PrintStream ps = new PrintStream(outFile);
	    FoodUtilities.writeFoods(foods, ps);
	    ps.close();
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	System.out.println(SEPARATOR);
	System.out.println("Get Food from keyboard:");

	final Scanner keyboard = new Scanner(System.in);
	food = FoodUtilities.getFood(keyboard);
	System.out.println();
	System.out.println(food);
	keyboard.close();
    }

    public static void testFoodCompareTo() {
	Food food = new Food("Lasagna", 7, false, 135);
	Food prevFood = new Food("Lasagna", 0, false, 135);
	Food nextFood = new Food("Lasagna", 11, false, 135);
	Food firstFood = new Food("Butter Chicken", 2, false, 490);
	Food lastFood = new Food("Szechuan Shrimp", 1, false, 516);

	System.out
	.println("Compare Italian Lasagna to itself (expects 0): " + food.compareTo(food));
	System.out
	.println("Compare Italian Lasagna to Butter Chicken (expects > 0): " + food.compareTo(firstFood));
	System.out
	.println("Compare Italian Lasagna to Szechuan Shrimp (expects < 0): " + food.compareTo(lastFood));
	System.out
	.println("Compare Italian Lasagna to Canadian Lasagna (expects > 0): " + food.compareTo(prevFood));
	System.out
	.println("Compare Italian Lasagna to English Lasagna (expects < 0): " + food.compareTo(nextFood));
    }

}
