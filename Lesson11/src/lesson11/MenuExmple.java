package lesson11;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuExmple extends JFrame implements ActionListener {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 700;

	private JPanel redPanel;
	private JPanel orangePanel;
	private JPanel bluePanel;

	public MenuExmple() {
		super("Menu Demonstration");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 3));

		bluePanel = new JPanel();
		bluePanel.setBackground(Color.LIGHT_GRAY);
		add(bluePanel);

		redPanel = new JPanel();
		redPanel.setBackground(Color.LIGHT_GRAY);
		add(redPanel);

		orangePanel = new JPanel();
		orangePanel.setBackground(Color.LIGHT_GRAY);
		add(orangePanel);

		JMenu colorMenu = new JMenu("Add Strips");

		JMenuItem blueChoice = new JMenuItem("Blue");
		blueChoice.addActionListener(this);
		colorMenu.add(blueChoice);

		JMenuItem redChoice = new JMenuItem("Red");
		redChoice.addActionListener(this);
		colorMenu.add(redChoice);

		JMenuItem orangeChoice = new JMenuItem("Orange");
		orangeChoice.addActionListener(this);
		colorMenu.add(orangeChoice);

		JMenuBar bar = new JMenuBar();
		bar.add(colorMenu);
		setJMenuBar(bar);
		// add(bar) ;
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
		MenuExmple gui = new MenuExmple();
		gui.setVisible(true);
	}
}
