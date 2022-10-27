package lesson11;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

public class FlowLayoutExample extends JFrame {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 400;

	public FlowLayoutExample() {
		super();
		setSize(WIDTH, HEIGHT);
		setTitle("Layout Demonstration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.yellow);

		setLayout(new FlowLayout());

	
		JLabel label1 = new JLabel("First label");
		add(label1);

		JLabel label2 = new JLabel("Second label");
		add(label2);

		JLabel label3 = new JLabel("Third label");
		add(label3);
	}

	public static void main(String[] args) {
		FlowLayoutExample gui = new FlowLayoutExample();
		gui.setVisible(true);
	}
}
