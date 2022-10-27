package cp213;

import java.io.FileNotFoundException;

import javax.swing.JFrame;

/**
 * Executes the GUI interface for this program.
 *
 * @author your name here
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2021-11-01
 */
public class RestaurantGUI {

    /**
     * @param args Unused.
     */
    public static void main(String[] args)  {
	try {
	    Menu menu = new Menu("menu.txt");
	    JFrame frame = new JFrame("WLU Foodorama");
	    frame.setContentPane(new OrderPanel(menu));
	    frame.setSize(280, 340);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	} catch (FileNotFoundException e) {
	    System.out.println("Cannot open menu file");
	}
    }
}