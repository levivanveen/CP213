package lesson12;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class WindowListenerDemo extends JFrame {
	public static final int WIDTH = 400; // for main window
	public static final int HEIGHT = 300; // for main window
	public static final int SMALL_WIDTH = 300; // for confirm window
	public static final int SMALL_HEIGHT = 200;// for confirm window

	private class CheckOnExit implements WindowListener {
		public void windowOpened(WindowEvent e) {
		}

		public void windowClosing(WindowEvent e) {
			ConfirmWindow checkers = new ConfirmWindow();
			checkers.setVisible(true);
		}

		public void windowClosed(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {
		}

		public void windowDeiconified(WindowEvent e) {
		}

		public void windowActivated(WindowEvent e) {
		}

		public void windowDeactivated(WindowEvent e) {
		}
	} // End of inner class CheckOnExit

	private class ConfirmWindow extends JFrame implements ActionListener {
		public ConfirmWindow() {
			setSize(SMALL_WIDTH, SMALL_HEIGHT);
			getContentPane().setBackground(Color.YELLOW);
			setLayout(new BorderLayout());

			JLabel confirmLabel = new JLabel("Are you sure you want to exit?", JLabel.CENTER);
			add(confirmLabel, BorderLayout.CENTER);

			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(Color.ORANGE);
			buttonPanel.setLayout(new FlowLayout());

			JButton exitButton = new JButton("Yes");
			exitButton.addActionListener(this);
			buttonPanel.add(exitButton);

			JButton cancelButton = new JButton("No");
			cancelButton.addActionListener(this);
			buttonPanel.add(cancelButton);

			add(buttonPanel, BorderLayout.SOUTH);
		}

		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();

			if (actionCommand.equals("Yes"))
				System.exit(0);
			else if (actionCommand.equals("No"))
				dispose();// Destroys only the ConfirmWindow.
			else
				System.out.println("Unexpected Error in Confirm Window.");
		}
	} // End of inner class ConfirmWindow

	public WindowListenerDemo() {
		setSize(WIDTH, HEIGHT);
		setTitle("Window Listener Demonstration");
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new CheckOnExit());

		getContentPane().setBackground(Color.LIGHT_GRAY);
		JLabel aLabel = new JLabel("Your window components should be inserted here", JLabel.CENTER);
		add(aLabel);
	}

	public static void main(String[] args) {
		WindowListenerDemo demoWindow = new WindowListenerDemo();
		demoWindow.setVisible(true);
	}
}
