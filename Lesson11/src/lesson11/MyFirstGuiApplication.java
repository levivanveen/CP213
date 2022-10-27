package lesson11;

import javax.swing.JFrame;
import javax.swing.JButton;

public class MyFirstGuiApplication  {
	public static final int WIDTH = 550;
	public static final int HEIGHT = 333;

	public static void main(String[] args) {
		JFrame firstWindow = new JFrame("My first Frame");
		
		firstWindow.setSize(WIDTH, HEIGHT);

        firstWindow.setDefaultCloseOperation(
                              JFrame.DISPOSE_ON_CLOSE);

		JButton closeButton = new JButton("Press Me");
		ButtonCloseListener button = new ButtonCloseListener();
		closeButton.addActionListener(button);
		firstWindow.add(closeButton);

		firstWindow.setVisible(true);
	}
}