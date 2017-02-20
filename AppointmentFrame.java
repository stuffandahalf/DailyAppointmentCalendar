import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class AppointmentFrame extends JFrame
{
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 600;
    
    private Calendar date;
    private SimpleDateFormat sdf;
    
    private JLabel label;
    
	public AppointmentFrame()
    {
        label = new JLabel();
        date = new GregorianCalendar();
        sdf = new SimpleDateFormat();
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        add(label, BorderLayout.NORTH);
    }
}

