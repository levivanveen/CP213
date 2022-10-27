package lesson12;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonWithIcon extends JFrame implements ActionListener {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 200;
	public static final int TEXT_FIELD_SIZE = 30;
	boolean flag = false ; ; 

	private JTextField message;

	public ButtonWithIcon() {
		super("Icon Demonstration");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBackground(Color.WHITE);
		setLayout(new BorderLayout());

		JLabel dukeLabel = new JLabel("Mood check");
		ImageIcon dukeIcon = new ImageIcon("src/duke_waving.gif");
		dukeLabel.setIcon(dukeIcon);
		add(dukeLabel, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		
		JButton happyButton = new JButton("Happy");
		ImageIcon happyIcon = new ImageIcon("src/smiley.gif");
		happyButton.setIcon(happyIcon);
		happyButton.addActionListener(this);
		buttonPanel.add(happyButton);
	//	happyButton.setMargin(new Insets (25, 25, 25, 25) );
		
		
		
		
		
		JButton sadButton = new JButton("Sad");
		ImageIcon sadIcon = new ImageIcon("src/sad.gif");
		sadButton.setIcon(sadIcon);
		sadButton.addActionListener(this);
		buttonPanel.add(sadButton);
		add(buttonPanel, BorderLayout.SOUTH);

		message = new JTextField(TEXT_FIELD_SIZE);
		add(message, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		

		if (actionCommand.equals("Happy")) {
			message.setText(message.getText() + "Smile " );
		 flag = true; 
		}else if (actionCommand.equals("Sad")) {
			if (flag ) {
				message.setText("");
				flag = false ; 
			}
			message.setText(message.getText() + "Cheer up.");
		}else
			message.setText("Unexpected Error.");
	}
	
	public static void main(String[] args) {
		ButtonWithIcon iconGui = new ButtonWithIcon();
		iconGui.setVisible(true);
	}

}
