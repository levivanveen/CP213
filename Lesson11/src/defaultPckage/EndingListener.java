package defaultPckage ; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndingListener implements ActionListener
{
    public void actionPerformed(ActionEvent event) 
    {
        System.out.println (" hello") ; 
    	System.exit(0);
    }
}
