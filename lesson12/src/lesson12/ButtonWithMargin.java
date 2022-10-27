package lesson12;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonWithMargin extends JFrame {

	ButtonWithMargin() {
		super();
	}

	public static void main(String args[]) {

		ButtonWithMargin bm = new ButtonWithMargin();

		bm.setSize(600, 400);
		bm.setLayout(new FlowLayout());
		bm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton b = new JButton("button1");
		b.setMargin(new Insets(150, 0, 0, 100));

		bm.setVisible(true);
	}

}
