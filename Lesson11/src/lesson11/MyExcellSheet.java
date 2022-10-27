package lesson11;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyExcellSheet extends JFrame {
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;

	public static void main(String[] args) {
		MyExcellSheet excellSheet = new MyExcellSheet(2, 3);
		excellSheet.setVisible(true);
	}

	public MyExcellSheet(int rows, int columns) {
		super();
		setSize(WIDTH, HEIGHT);
		setTitle("GridLayout Demonstration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout gLayout = new GridLayout (rows, columns) ; 
		gLayout.setVgap(100);
		gLayout.setHgap(100);

		setLayout(gLayout);

		JTextField field1 = new JTextField();
		add(field1) ; 
		JTextField field2 = new JTextField();
		add(field2);
		JTextField field3 = new JTextField();
		add(field3);
		JTextField field4 = new JTextField();
		add(field4);
		JTextField field5 = new JTextField();
		add(field5);


	}
}
