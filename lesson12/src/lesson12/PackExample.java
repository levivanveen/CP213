package lesson12;

import java.awt.*;
import javax.swing.*;

public class PackExample extends JFrame {
	public PackExample() {
		setTitle("Testing pack method");
		setLayout(new FlowLayout());
		setButton();
		pack(); // calling the pack() method
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	void setButton() {
		for (int i = 1; i < 6; i++) {
			add(new JButton("Button" + i));
		}
	}

	public static void main(String args[]) {
		new PackExample();
	}
}
