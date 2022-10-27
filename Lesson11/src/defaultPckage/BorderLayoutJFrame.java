package defaultPckage ; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.TextField;

public class BorderLayoutJFrame extends JFrame
{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;

    public BorderLayoutJFrame( )
    {
        super("BorderLayout Demonstration" );
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout( ));

        JLabel label1 = new JLabel("First Name ");
        add(label1, BorderLayout.NORTH); 

        TextField label2 = new TextField();
        add(label2, BorderLayout.SOUTH); 

        JLabel label3 = new JLabel("Last Name");
        add(label3, BorderLayout.CENTER); 
    }
}

