package cp213;

import java.io.FileNotFoundException;

/**
 * Executes the text-based interface for this program.
 *
 * @author your name here
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2021-11-01
 */
public class RestaurantText {

    /**
     * @param args Unused.
     */
    public static void main(String[] args)  {
	try {
	    Menu menu = new Menu("menu.txt");
	    Cashier cashier = new Cashier(menu);
	    cashier.takeOrder();
	} catch (FileNotFoundException e) {
	    System.out.println("Cannot open menu file");
	}
	System.exit(0);
    }
}