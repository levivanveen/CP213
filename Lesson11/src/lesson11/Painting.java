package lesson11;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Painting extends JFrame implements ActionListener {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 700;

	private JPanel bluePanel;
	private JPanel redPanel;
	private JPanel orangePanel;

	public Painting() {
		super("Panel Demonstration");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel biggerPanel = new JPanel();
		biggerPanel.setLayout(new GridLayout(1, 3));

		bluePanel = new JPanel();
		bluePanel.setBackground(Color.LIGHT_GRAY);
		biggerPanel.add(bluePanel);

		redPanel = new JPanel();
		redPanel.setBackground(Color.LIGHT_GRAY);
		biggerPanel.add(redPanel);

		orangePanel = new JPanel();
		orangePanel.setBackground(Color.LIGHT_GRAY);
		biggerPanel.add(orangePanel);

		add(biggerPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		buttonPanel.setLayout(new FlowLayout());

		JButton blueButton = new JButton("Blue");
		blueButton.setBackground(Color.BLUE);
		blueButton.addActionListener(this);
		buttonPanel.add(blueButton);

		JButton redButton = new JButton("Red");
		redButton.setBackground(Color.RED);
		redButton.addActionListener(this);
		buttonPanel.add(redButton);

		JButton orangeButton = new JButton("Orange");
		orangeButton.setBackground(Color.ORANGE);
		orangeButton.addActionListener(this);
		buttonPanel.add(orangeButton);

		add(buttonPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		String buttonString = e.getActionCommand();

		if (buttonString.equals("Red"))
			redPanel.setBackground(Color.RED);
		else if (buttonString.equals("Orange"))
			orangePanel.setBackground(Color.ORANGE);
		else if (buttonString.equals("Blue"))
			bluePanel.setBackground(Color.BLUE);
		else
			System.out.println("Unexpected error.");
	}

	public static void main(String[] args) {
		Painting gui = new Painting();
		gui.setVisible(true);
	}
}
