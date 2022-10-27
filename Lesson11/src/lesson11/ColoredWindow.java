package lesson11;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class ColoredWindow extends JFrame {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;

	public ColoredWindow(Color theColor) {
		super("Color is Object in Java");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setBackground(theColor);

		JLabel aLabel = new JLabel("Content Pane is used for Coloring JFrame.");
		add(aLabel);
	}

	public ColoredWindow() {
		this(Color.PINK);
	}

	public static void main(String[] args) {
		ColoredWindow pinkWindow = new ColoredWindow();
		pinkWindow.setVisible(true);

		ColoredWindow yelloWinodw = new ColoredWindow(Color.YELLOW);
		yelloWinodw.setVisible(true);
	}
}
