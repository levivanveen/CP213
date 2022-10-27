package lesson11;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

public class BoarderLayoutForm extends JFrame {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 400;

	public BoarderLayoutForm() {
		super("using boarder layout");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(BorderFactory.createBevelBorder(0));
		panel1.setBackground(Color.YELLOW);
		add(panel1, BorderLayout.NORTH);

		JLabel label1 = new JLabel("First Name");
		panel1.add(label1, BorderLayout.EAST);

		JLabel label2 = new JLabel("Address");
		panel1.add(label2, BorderLayout.WEST);

	}
}
