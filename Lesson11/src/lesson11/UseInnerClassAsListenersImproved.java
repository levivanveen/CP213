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

public class UseInnerClassAsListenersImproved extends JFrame {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 700;

	private JPanel redPanel;
	private JPanel orangePanel;
	private JPanel bluePanel;

	private class ColorListener implements ActionListener {
		private JPanel thePanel;
		private Color theColor;

		public ColorListener(Color c, JPanel p) {
			theColor = c;
			thePanel = p;
		}

		public void actionPerformed(ActionEvent e) {
			thePanel.setBackground(theColor);
		}
	} // End of ColorListener inner class

	public static void main(String[] args) {
		UseInnerClassAsListenersImproved gui = new UseInnerClassAsListenersImproved();
		gui.setVisible(true);
	}

	public UseInnerClassAsListenersImproved() {
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
		blueChoice.addActionListener(new ColorListener(Color.BLUE, bluePanel));
		colorMenu.add(blueChoice);

		JMenuItem redChoice = new JMenuItem("Red");
		redChoice.addActionListener(new ColorListener(Color.RED, redPanel));
		colorMenu.add(redChoice);

		JMenuItem whiteChoice = new JMenuItem("Orange");
		whiteChoice.addActionListener(new ColorListener(Color.ORANGE, orangePanel));
		colorMenu.add(whiteChoice);

		JMenuBar bar = new JMenuBar();
		bar.add(colorMenu);
		setJMenuBar(bar);
	}
}
