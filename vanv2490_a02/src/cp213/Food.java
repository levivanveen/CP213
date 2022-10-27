package cp213;

import java.io.PrintStream;

/**
 * Food class definition.
 *
 * @author David Brown
 * @version 2021-09-24
 */
public class Food implements Comparable<Food> {

    // Constants
    public static final String ORIGINS[] = { "Canadian", "Chinese", "Indian", "Ethiopian", "Mexican", "Greek",
	    "Japanese", "Italian", "Moroccan", "Scottish", "Columbian", "English" };

    /**
     * Creates a string of food origins in the format:
     *
     * <pre>
Origins
 0 Canadian
 1 Chinese
...
11 English
     * </pre>
     *
     * @return A formatted numbered string of valid food origins.
     */
    public static String originsMenu() {
    	String menu = "Origins\n"; 
    	String num = "";
    	for (int i = 0; i < ORIGINS.length; i++) {
    		num = String.format("%2d", i);
    		menu = menu + num + " " + ORIGINS[i] + '\n';
    	}
	return menu;
    }

    // Attributes
    private String name = null;
    private int origin = 0;
    private boolean isVegetarian = false;
    private int calories = 0;

    /**
     * Food constructor.
     *
     * @param name         food name
     * @param origin       food origin code
     * @param isVegetarian whether food is vegetarian
     * @param calories     caloric content of food
     */
    public Food(final String name, final int origin, final boolean isVegetarian, final int calories) {
    	this.name = name;
    	this.origin = origin;
    	this.isVegetarian = isVegetarian;
    	this.calories = calories;
    }

    /*
     * (non-Javadoc) Compares this food against another food.
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    /**
     * Foods are compared by name, then by origin if the names match.
     * Must ignore case.
     */
    @Override
    public int compareTo(final Food target) {
    	if (this.name.toLowerCase().compareTo(target.name.toLowerCase()) == 0) {
    		if (this.origin == target.origin) {
    			return 0;
    		}
    		else if (this.origin > target.origin)
    			return 11;
    		else
    			return -14;
    	}
    	else if (this.name.toLowerCase().compareTo(target.name.toLowerCase()) > 0)
    		return 11;
	return -14;
    }

    /**
     * Getter for calories attribute.
     *
     * @return calories
     */
    public int getCalories() {
	return calories;
    }

    /**
     * Getter for name attribute.
     *
     * @return name
     */
    public String getName() {
	return name;
    }

    /**
     * Getter for origin attribute.
     *
     * @return origin
     */
    public int getOrigin() {
	return origin;
    }

    /**
     * Getter for string version of origin attribute.
     *
     * @return string version of origin
     */
    public String getOriginString() {
	return ORIGINS[this.origin];
    }

    /**
     * Getter for isVegetarian attribute.
     *
     * @return isVegetarian
     */
    public boolean isVegetarian() {
	return isVegetarian;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object//toString() Creates a formatted string of food data.
     */
    /**
     * Returns a string version of a Food object in the form:
<pre>
Name:       name
Origin:     origin string
Vegetarian: true/false
Calories:   calories
</pre>
     */
    @Override
    public String toString() {
    	String foodString = "";
    	foodString = String.format("Name:       %s", this.name);
    	foodString = foodString + "\n" + String.format("Origin:     %s", getOriginString());
    	foodString = foodString + "\n" + String.format("Vegetarian: %s", this.isVegetarian);
    	foodString = foodString + "\n" + String.format("Calories:   %s", this.calories);
    	foodString = foodString + "\n";

	return foodString;
    }

    /**
     * Writes a single line of food data to an open PrintStream. The contents of
     * food are written as a string in the format name|origin|isVegetarian|calories to ps.
     *
     * @param ps The PrintStream to write to.
     */
    public void write(final PrintStream ps) {
    	String foodData = "";
    	foodData = this.name + "|" + getOriginString() + "|" + this.isVegetarian + "|" + this.calories;
    	ps.print(foodData);
	return;
    }

}
