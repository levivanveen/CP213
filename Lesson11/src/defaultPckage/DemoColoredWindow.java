package defaultPckage ; 
import java.awt.Color;

public class DemoColoredWindow
{
    public static void main(String[] args) 
    {
        ColoredWindow w1 = new ColoredWindow( );
        w1.setVisible(true);

        ColoredWindow w2 = new ColoredWindow(Color.CYAN);
        w2.setVisible(true);
    }
}
