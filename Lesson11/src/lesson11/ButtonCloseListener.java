package lesson11;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonCloseListener implements ActionListener
{
    public void actionPerformed(ActionEvent e) 
    {
        System.out.println ("Button is pressed, window closed") ; 
    	System.exit(0);
    }
}
