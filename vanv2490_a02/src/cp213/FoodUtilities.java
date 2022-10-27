package cp213;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utilities for working with Food objects.
 *
 * @author David Brown
 * @version 2021-09-24
 */
public class FoodUtilities {

    /**
     * Determines the average calories in a list of foods. No rounding necessary.
     * Foods list parameter may be empty.
     *
     * @param foods a list of Food
     * @return average calories in all Food objects
     */
    public static int averageCalories(final ArrayList<Food> foods) {
    	int averageCals = 0, totalCals = 0, size = foods.size();
    	for (int i = 0; i < size; i++ ) {
    		totalCals = totalCals + foods.get(i).getCalories();
    	}
    	averageCals = totalCals / size;
	return averageCals;
    }

    /**
     * Determines the average calories in a list of foods for a particular origin.
     * No rounding necessary. Foods list parameter may be empty.
     *
     * @param foods  a list of Food
     * @param origin the origin of the Food
     * @return average calories for all Foods of the specified origin
     */
    public static int averageCaloriesByOrigin(final ArrayList<Food> foods, final int origin) {
    	ArrayList<Food> originList = getByOrigin(foods, origin);
    	int average = averageCalories(originList);
	return average;
    }

    /**
     * Creates a list of foods by origin.
     *
     * @param foods  a list of Food
     * @param origin a food origin
     * @return a list of Food from origin
     */
    public static ArrayList<Food> getByOrigin(final ArrayList<Food> foods, final int origin) {
    	int size = foods.size();
    	ArrayList<Food> list = new ArrayList<Food>();
    	
    	for (int i = 0; i < size; i++) {
    		if (foods.get(i).getOrigin() == origin)
    			list.add(foods.get(i));
    	}
    	
	return list;
    }

    /**
     * Creates a Food object by requesting data from a user. Uses the format:
     *
     * <pre>
    Name: name
    Origins
     0 Canadian
     1 Chinese
    ...
    11 English
    Origin: origin number
    Vegetarian (Y/N): Y/N
    Calories: calories
     * </pre>
     *
     * @param keyboard a keyboard Scanner
     * @return a Food object
     */
    public static Food getFood(final Scanner keyboard) {
    	boolean veggie;
    	System.out.print("Name: ");
    	String name = keyboard.nextLine();
    	
    	System.out.println(Food.originsMenu());
    	System.out.print("Origin: ");
    	int origin = keyboard.nextInt();
    	
    	System.out.print("Vegetarian (Y/N): ");
    	String vegetarian = keyboard.next();
    	
    	System.out.print("Calories: ");
    	int calories = keyboard.nextInt();
    	
    	if (origin > 11 || origin < 0) {
    		return null;
    	}
    	
    	if (vegetarian.toUpperCase().compareTo("Y") == 0)
    		veggie = true;
    	else
    		veggie = false;
    	
    	Food food = new Food(name, origin, veggie, calories);
	return food;
    }

    /**
     * Creates a list of vegetarian foods.
     *
     * @param foods a list of Food
     * @return a list of vegetarian Food
     */
    public static ArrayList<Food> getVegetarian(final ArrayList<Food> foods) {
    	int size = foods.size();
    	ArrayList<Food> veggie = new ArrayList<Food>();
    	
    	for (int i = 0; i < size; i++) {
    		if (foods.get(i).isVegetarian())
    			veggie.add(foods.get(i));
    	}
    	
	return veggie;
    }

    /**
     * Creates and returns a Food object from a line of string data.
     *
     * @param line a vertical bar-delimited line of food data in the format
     *             name|origin|isVegetarian|calories
     * @return the data from line as a Food object
     */
    public static Food readFood(final String line) {
    	int counter = 0, origin = 0, calories = 0;
    	char letter;
    	String name = "", veggie = "", org = "", cal = "";
    	boolean vegetarian;
    	
    	for (int i = 0; i < line.length(); i++) {
    		letter = line.charAt(i);
    		if (letter == '|') {
    			counter = counter + 1;
    			continue;
    		}
    		if (counter == 0) {
    			name = name + letter;
    		}
    		else if (counter == 1) {
    			org = org + letter;
    		}
    		else if (counter == 2) {
    			veggie = veggie + letter;
    		}
    		else {
    			cal = cal + letter;
    		}
    	}
    	calories = Integer.parseInt(cal);
    	origin = Integer.parseInt(org);
    	
    	if (veggie.toLowerCase().compareTo("false") == 0)
    		vegetarian = false;
    	else
    		vegetarian = true;
    	
    	Food food = new Food(name, origin, vegetarian, calories);

	return food;
    }

    /**
     * Reads a file of food strings into a list of Food objects.
     *
     * @param fileIn a Scanner of a Food data file in the format
     *               name|origin|isVegetarian|calories
     * @return a list of Food
     */
    public static ArrayList<Food> readFoods(final Scanner fileIn) {
    	String inputLine = "";    	
    	ArrayList<Food> list = new ArrayList<Food>();
    	
    	while (fileIn.hasNextLine()) {
    		inputLine = fileIn.nextLine();
    		Food food = readFood(inputLine);
    		list.add(food);
    	}
    		
    	
	return list;
    }

    /**
     * Searches for foods that fit certain conditions.
     *
     * @param foods        a list of Food
     * @param origin       the origin of the food; if -1, accept any origin
     * @param maxCalories  the maximum calories for the food; if 0, accept any
     * @param isVegetarian whether the food is vegetarian or not; if false accept
     *                     any
     * @return a list of foods that fit the conditions specified
     */
    public static ArrayList<Food> foodSearch(final ArrayList<Food> foods, final int origin, final int maxCalories,
	    final boolean isVegetarian) {
    	ArrayList<Food> list = new ArrayList<Food>();
    	int size = foods.size();
    	
    	for (int i = 0; i < size; i++) {
    		if (origin == -1 || foods.get(i).getOrigin() == origin) {
    			if (maxCalories == 0 || foods.get(i).getCalories() <= maxCalories) {
    				if (isVegetarian == false)
    					list.add(foods.get(i));
    				else if (foods.get(i).isVegetarian() == true)
    					list.add(foods.get(i));
    			}
    		}
    			
    	}

	return list;
    }

    /**
     * Writes the contents of a list of Food to a PrintStream.
     *
     * @param foods a list of Food
     * @param ps    the PrintStream to write to
     */
    public static void writeFoods(final ArrayList<Food> foods, PrintStream ps) {
    	int size = foods.size();
    	for (int i = 0; i < size; i++) {
    		foods.get(i).write(ps);
    	}
    return;	
    }
}
