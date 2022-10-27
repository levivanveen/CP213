Apackage lesson11;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UseInnerClassAsListeners extends JFrame {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 700;

	private JPanel redPanel;
	private JPanel orangePanel;
	private JPanel bluePanel;

	private class RedListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			redPanel.setBackground(Color.RED);
		}
	} // End of RedListener inner class

	private class OrangeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			orangePanel.setBackground(Color.ORANGE);
		}
	} // End of WhiteListener inner class

	private class BlueListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bluePanel.setBackground(Color.BLUE);
		}
	} // End of BlueListener inner class

	public UseInnerClassAsListeners() {
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

		JMenu colorMenu = new JMenu("Add strips");
		
		JMenuItem blueChoice = new JMenuItem("Blue");
		blueChoice.addActionListener(new BlueListener());
		colorMenu.add(blueChoice);
		
		JMenuItem redChoice = new JMenuItem("Red");
		redChoice.addActionListener(new RedListener());
		colorMenu.add(redChoice);

		JMenuItem whiteChoice = new JMenuItem("Orange");
		whiteChoice.addActionListener(new OrangeListener());
		colorMenu.add(whiteChoice);

		JMenuBar bar = new JMenuBar();
		bar.add(colorMenu);
		setJMenuBar(bar);
	}

	public static void main(String[] args) {
		UseInnerClassAsListeners gui = new UseInnerClassAsListeners();
		gui.setVisible(true);
	}
}
