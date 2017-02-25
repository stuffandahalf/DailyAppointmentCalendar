import java.awt.BorderLayout;
import java.awt.event.*;//ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;


public class OldAppointmentFrame extends JFrame
{
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 300;
    
    private Calendar date;
    private SimpleDateFormat sdf;
    private ArrayList<Appointment> appointments;
    
    private JLabel dateLabel;
    private JTextArea textArea;
    
    private JScrollPane scrollPane;
    
    private JPanel controlPanel;
    private JPanel datePanel;
    private JPanel actionPanel;
    private JPanel subDatePanelA;
    private JPanel subDatePanelB;
    
    private JButton leftButton;
    private JButton rightButton;
    
    private JTextField month;
    private JTextField day;
    private JTextField year;
    private JTextField hours;
    private JTextField minutes;
    private JButton createButton;
    
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
        dateLabel = new JLabel(sdf.format(date.getTime()));
        add(dateLabel, BorderLayout.NORTH);
    }
    
    private void createTextArea()
    {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void createControlPanel()
    {
        controlPanel = new JPanel(new BorderLayout());
        createDateSubpanel();
        createActionSubpanel();
        
        add(controlPanel, BorderLayout.SOUTH);
    }
    
    private void createDateSubpanel()
    {
        datePanel = new JPanel(new BorderLayout());
        subDatePanelA = new JPanel();//new BorderLayout());
        datePanel.add(subDatePanelA, BorderLayout.NORTH);
        subDatePanelB = new JPanel(new BorderLayout());
        datePanel.add(subDatePanelB, BorderLayout.CENTER);
        
        createLeftButton();
        createRightButton();
        
        day = new JTextField();
        subDatePanelB.add(day, BorderLayout.WEST);
        
        month = new JTextField();
        subDatePanelB.add(month, BorderLayout.CENTER);
        
        year = new JTextField();
        subDatePanelB.add(month, BorderLayout.EAST);
        
        controlPanel.add(datePanel, BorderLayout.NORTH);
    }
    
    private void createLeftButton()
    {
        class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent evt)
            {
                date.add(Calendar.DAY_OF_MONTH, -1);
                System.out.println(sdf.format(date.getTime()));
                dateLabel.setText(sdf.format(date.getTime()));
            }
        }
        
        leftButton = new JButton("<");
        leftButton.addActionListener(new Listener());
        
        subDatePanelA.add(leftButton);//, BorderLayout.WEST);
    }
    
    private void createRightButton()
    {
        class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent evt)
            {
                date.add(Calendar.DAY_OF_MONTH, 1);
                System.out.println(sdf.format(date.getTime()));
                dateLabel.setText(sdf.format(date.getTime()));
            }
        }
        
        rightButton = new JButton(">");
        rightButton.addActionListener(new Listener());
        
        subDatePanelA.add(rightButton);//, BorderLayout.EAST);
    }

    private void createActionSubpanel()
    {
        actionPanel = new JPanel(new BorderLayout());
        hours = new JTextField();
        minutes = new JTextField();
        createCreateButton();
        
        actionPanel.add(hours, BorderLayout.WEST);
        actionPanel.add(minutes, BorderLayout.EAST);
        controlPanel.add(actionPanel, BorderLayout.SOUTH);
    }
    
    private void createCreateButton()
    {
        createButton = new JButton();
        class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent evt)
            {
                
            }
        }
        createButton.addActionListener(new Listener());
        actionPanel.add(createButton);
    }

}

