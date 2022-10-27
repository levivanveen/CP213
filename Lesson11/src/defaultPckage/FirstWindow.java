package defaultPckage ; 
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class FirstWindow extends JFrame 
{
    public static final int WIDTH = 500; 
    public static final int HEIGHT = 500;

    public FirstWindow( )
    {
        super( );
        setSize(WIDTH, HEIGHT);

        setTitle("First Window Class");

        setDefaultCloseOperation(
                              JFrame.DO_NOTHING_ON_CLOSE);

        JButton endButton = new JButton("Click to end program.");
       
        endButton.addActionListener(new EndingListener ());
        add(endButton);
    }
    
   
}
