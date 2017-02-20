import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;


public class AppointmentFrame extends JFrame
{
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 600;
    
    private Calendar date;
    private SimpleDateFormat sdf;
    private ArrayList<Appointment> appointments;
    
    private JLabel label;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JPanel controlPanel;
    
	public AppointmentFrame()
    {
        date = new GregorianCalendar();
        sdf = new SimpleDateFormat();
        appointments = new ArrayList<Appointment>();
        
        createLabel();
        createTextArea();
        createControlPanel();
        
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }
    
    private void createLabel()
    {
        label = new JLabel();
        add(label, BorderLayout.NORTH);
    }
    
    private void createTextArea()
    {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void createControlPanel()
    {
        controlPanel = new JPanel();
        
        add(controlPanel, BorderLayout.SOUTH);
    }
}

