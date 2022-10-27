package lesson11;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FirstWindowApplication extends JFrame implements ActionListener {
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;

	public FirstWindowApplication() {
		super();
		setSize(WIDTH, HEIGHT);

		setTitle("First Window Class");

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JButton closeButton = new JButton("Press Me.");

		closeButton.addActionListener(this);
		add(closeButton);

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println (e.getActionCommand()) ; 
		System.exit(0);
	}
	public static void main(String[] args) {
		FirstWindowApplication w = new FirstWindowApplication();
		w.setVisible(true);
	}
}
