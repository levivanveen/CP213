package cp213;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

/**
 * Stores a List of MenuItems and provides a method return these items in a
 * formatted String. May be constructed from an existing List or from a file
 * with lines in the format:
 *
 * <pre>
1.25 hot dog
10.00 pizza
...
 * </pre>
 *
 * @author Levi Van Veen
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2021-11-01
 */
public class Menu {

    /**
     * For testing. Reads contents of "menu.txt" from root of project.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
	try {
	    Menu menu = new Menu("menu.txt");
	    System.out.println(menu.toString());
	} catch (FileNotFoundException e) {
	    System.out.println("Cannot open menu file");
	}
	System.exit(0);
    }

    private List<MenuItem> items = new ArrayList<MenuItem>();

    /**
     * Constructor from a file of MenuItem strings. Each line in the file
     * corresponds to a MenuItem. You have to read the file line by line and add
     * each MenuItem to the ArrayList of items.
     *
     * @param filename The name of the file containing the menu items.
     * @throws FileNotFoundException Thrown if file not found or cannot be read.
     */
    public Menu(String filename) throws FileNotFoundException {

		File menu = new File(filename);
		Scanner reader = new Scanner(menu);
		
		while (reader.hasNextLine()) {
			Scanner line = new Scanner(reader.nextLine());
			String name = "";
			double price = 0;
			
			while (line.hasNextDouble()) {		//Get price
				price = line.nextDouble();
			}
			while (line.hasNext()) {			//Get name of food
				if (name == "")
					name = line.next();
				else
					name = name + " " + line.next();
			}
			if (price != 0 && name != "") {
				MenuItem item = new MenuItem(name, price);
				this.items.add(item);
			}

		}
		reader.close();
    }

    /**
     * Returns the List's i-th MenuItem.
     *
     * @param i Index of a MenuItem.
     * @return the MenuItem at index i
     */
    public MenuItem getItem(int i) {
    	MenuItem item = this.items.get(i);
	return item;
    }

    /**
     * Returns the Menu items as a String in the format:
     *
     * <pre>
    5) poutine      $ 3.75
    6) pizza        $10.00
     * </pre>
     *
     * where n) is the index + 1 of the MenuItems in the List.
     */
    @Override
    public String toString() {
    	String menuString = "";
    	for (int i = 0; i < this.items.size(); i++) {
    		menuString = menuString + " " + (i + 1) + ") " + getItem(i).toString() + "\n";
    	}
	return menuString;
    }

    /**
     * Returns the number of MenuItems in the items List.
     *
     * @return Size of the items List.
     */
    public int size() {
	return this.items.size();
    }
}