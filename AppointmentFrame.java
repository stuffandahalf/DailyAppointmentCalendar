//importing java libraries
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


public class AppointmentFrame extends JFrame
{
    //instance variables for window size
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 300;
    
    //variables used for the appointments
    private Calendar date;
    private SimpleDateFormat sdf;
    private ArrayList<Appointment> appointments;
    
    //gui instance variables
    private JLabel dateLabel;
    private JTextArea textArea;
    
    private JScrollPane scrollPane;
    
    private JPanel controlPanel;
    private JPanel datePanel;
    private JPanel actionPanel;
    private JPanel subDatePanelA;
    private JPanel subDatePanelB;
    private JPanel subDatePanelC;
    
    private JButton leftButton;
    private JButton rightButton;
    private JButton showButton;
    
    private JTextField month;
    private JTextField day;
    private JTextField year;
    private JTextField hours;
    private JTextField minutes;
    private JButton createButton;
    
    /**
     * constructor for the frame
     */
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
    
    /**
     * method to create JLabel for frame
     */
    private void createLabel()
    {
        dateLabel = new JLabel(sdf.format(date.getTime()));
        add(dateLabel, BorderLayout.NORTH);
    }
    
    /**
     * method to create main text area
     */
    private void createTextArea()
    {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    /**
     * method to create control panel of the frame
     */
    private void createControlPanel()
    {
        controlPanel = new JPanel(new BorderLayout());
        createDateSubpanel();
        //createActionSubpanel();
        
        add(controlPanel, BorderLayout.SOUTH);
    }
    
    /**
     * create the subpanel to adjust the date
     */
    private void createDateSubpanel()
    {
        datePanel = new JPanel(new BorderLayout());
        
        subDatePanelA = new JPanel();
        datePanel.add(subDatePanelA, BorderLayout.NORTH);
        createLeftButton();
        createRightButton();
        
        subDatePanelB = new JPanel(new BorderLayout());
        day = new JTextField(2);
        subDatePanelB.add(day, BorderLayout.WEST);
        
        month = new JTextField(2);
        subDatePanelB.add(month, BorderLayout.CENTER);
        
        year = new JTextField(2);
        subDatePanelB.add(month, BorderLayout.EAST);
        datePanel.add(subDatePanelB, BorderLayout.CENTER);
        
        subDatePanelC = new JPanel(new BorderLayout());
        createShowButton();
        datePanel.add(subDatePanelA, BorderLayout.SOUTH);
        
        controlPanel.add(datePanel, BorderLayout.NORTH);
    }
    
    /**
     * create the left button
     */
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
        
        subDatePanelA.add(leftButton);
    }
    
    /**
     * create the right button
     */
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
        
        subDatePanelA.add(rightButton);
    }
    
    private void createShowButton()
    {
        showButton = new JButton("Show");
        class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Show button was pressed");
            }
        }
        showButton.addActionListener(new Listener());
        subDatePanelC.add(showButton, BorderLayout.CENTER);
    }
    
    /**
     * create the subpanel for the actions
     */
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
    
    /**
     * create the create button
     */
    private void createCreateButton()
    {
        createButton = new JButton();
        class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Show button was pressed");
            }
        }
        createButton.addActionListener(new Listener());
        actionPanel.add(createButton);
    }

}

