//Name: Gregory Norton
//Student ID: 500766165
//Class: CPS 209


//importing java libraries
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class AppointmentFrame extends JFrame
{
    //instance variables for window size
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 600;
    
    //variables used for the appointments
    private Calendar date;
    private SimpleDateFormat sdf;
    private ArrayList<Appointment> appointments;
    
    //gui instance variables
    private JLabel dateLabel;
    private JTextArea textArea;
    
    private JScrollPane scrollPane;
    
    private JPanel controlPanel;
    
    private TitledBorder dateBorder;
    private JPanel datePanel;
    
    private JPanel subDatePanelA;
    private JButton leftButton;
    private JButton rightButton;
    
    private JPanel subDatePanelB;
    private JLabel monthLabel;
    private JTextField monthInput;
    private JLabel dayLabel;
    private JTextField dayInput;
    private JLabel yearLabel;
    private JTextField yearInput;
    
    private JPanel subDatePanelC;
    private JButton showButton;
    
    private TitledBorder actionBorder;
    private JPanel actionPanel;
    
    private JPanel subActionPanelA;
    private JLabel hourLabel;
    private JLabel minuteLabel;
    private JTextField hourInput;
    private JTextField minuteInput;
    
    private JPanel subActionPanelB;
    private JButton createButton;
    private JButton cancelButton;
    
    private JPanel descriptionPanel;
    private TitledBorder descriptionBorder;
    private JTextArea description;
    
    
    
    /**
     * constructor for the frame
     */
	public AppointmentFrame()
    {
        super();
        date = new GregorianCalendar();
        sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
        appointments = new ArrayList<Appointment>();
        
        createLabel();
        createTextArea();
        createControlPanel();
        
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
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
        textArea.setEditable(false);
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
        createActionSubpanel();
        createDescriptionSubpanel();
        
        add(controlPanel, BorderLayout.SOUTH);
    }
    
    
    /**
     * create the subpanel to adjust the date
     */
    private void createDateSubpanel()
    {
        dateBorder = new TitledBorder("Date");
        dateBorder.setTitleJustification(TitledBorder.LEFT);
        datePanel = new JPanel(new BorderLayout());
        datePanel.setBorder(dateBorder);
        
        subDatePanelA = new JPanel(new GridLayout(1, 2));
        datePanel.add(subDatePanelA, BorderLayout.NORTH);
        createLeftButton();
        createRightButton();
        
        subDatePanelB = new JPanel();//new BorderLayout());
        
        dayLabel = new JLabel("Day");
        subDatePanelB.add(dayLabel);
        dayInput = new JTextField(Integer.toString(date.get(Calendar.DAY_OF_MONTH)), 2);
        subDatePanelB.add(dayInput);//, BorderLayout.WEST);
        
        monthLabel = new JLabel("Month");
        subDatePanelB.add(monthLabel);
        monthInput = new JTextField(Integer.toString(date.get(Calendar.MONTH)+1), 2);
        subDatePanelB.add(monthInput);//, BorderLayout.CENTER);
        
        yearLabel = new JLabel("Year");
        subDatePanelB.add(yearLabel);
        yearInput = new JTextField(Integer.toString(date.get(Calendar.YEAR)), 4);
        subDatePanelB.add(yearInput);//, BorderLayout.EAST);
        datePanel.add(subDatePanelB, BorderLayout.CENTER);
        
        subDatePanelC = new JPanel();//new BorderLayout());
        createShowButton();
        datePanel.add(subDatePanelC, BorderLayout.SOUTH);
        
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
                dateLabel.setText(sdf.format(date.getTime()));
                getTodaysAppointments();
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
                dateLabel.setText(sdf.format(date.getTime()));
                getTodaysAppointments();
            }
        }
        
        rightButton = new JButton(">");
        rightButton.addActionListener(new Listener());
        
        subDatePanelA.add(rightButton);
    }
    
    /**
     * create the show button
     */
    private void createShowButton()
    {
        showButton = new JButton("Show");
        class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent evt)
            {
                //System.out.println("Show button was pressed");
                
                String year = yearInput.getText();
                if(!year.equals(""))
                {
                    date.set(Calendar.YEAR, Integer.parseInt(yearInput.getText()));
                }
                String month = monthInput.getText();
                if(!month.equals(""))
                {
                    date.set(Calendar.MONTH, Integer.parseInt(monthInput.getText())-1);
                }
                String day = dayInput.getText();
                if(!day.equals(""))
                {
                    date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dayInput.getText()));
                }
                //System.out.println(dayInput.getText());
                //System.out.println(sdf.format(date.getTime()));
                yearInput.setText(Integer.toString(date.get(Calendar.YEAR)));
                monthInput.setText(Integer.toString(date.get(Calendar.MONTH)+1));
                dayInput.setText(Integer.toString(date.get(Calendar.DAY_OF_MONTH)));
                dateLabel.setText(sdf.format(date.getTime()));
                getTodaysAppointments();
            }
        }
        showButton.addActionListener(new Listener());
        subDatePanelC.add(showButton, BorderLayout.CENTER);
    }
    
    /**
     * method to get and print the
     * appointments for the day to
     * the JTextArea
     */
    private void getTodaysAppointments()
    {
        textArea.setText("");
        Collections.sort(appointments);
        for(int i = 0; i < appointments.size(); i++)
        {
            Calendar apptDate = appointments.get(i).getDate();
            if(apptDate.get(Calendar.YEAR) == date.get(Calendar.YEAR) && 
               apptDate.get(Calendar.MONTH) == date.get(Calendar.MONTH) &&
               apptDate.get(Calendar.DAY_OF_MONTH) == date.get(Calendar.DAY_OF_MONTH))
            {
                textArea.append(appointments.get(i).print());
                textArea.append("\n\n");
            }
        }
    }
 
    
    
    /**
     * create the subpanel for the actions
     */
    private void createActionSubpanel()
    {
        actionBorder = new TitledBorder("Action");
        actionBorder.setTitleJustification(TitledBorder.LEFT);
        actionPanel = new JPanel(new BorderLayout());
        actionPanel.setBorder(actionBorder);
        
        subActionPanelA = new JPanel();
        hourLabel = new JLabel("Hour");
        subActionPanelA.add(hourLabel);
        hourInput = new JTextField(2);
        subActionPanelA.add(hourInput);
        minuteLabel = new JLabel("Minute");
        subActionPanelA.add(minuteLabel);
        minuteInput = new JTextField(2);
        subActionPanelA.add(minuteInput);
        actionPanel.add(subActionPanelA, BorderLayout.NORTH);
        
        subActionPanelB = new JPanel();
        createCreateButton();
        createCancelButton();
        actionPanel.add(subActionPanelB, BorderLayout.CENTER);
        
        controlPanel.add(actionPanel, BorderLayout.CENTER);
    }
    
    /**
     * create the create button
     */
    private void createCreateButton()
    {
        createButton = new JButton("Create");
        class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent evt)
            {
                boolean create = true;
                int year = date.get(Calendar.YEAR);
                int month = date.get(Calendar.MONTH);
                int day = date.get(Calendar.DAY_OF_MONTH);
                
                String hour = hourInput.getText();
                String minute = minuteInput.getText();
                if(hour.equals(""))
                {
                    description.setText("ERROR");
                }
                else
                {
                    if(minute.equals(""))
                    {
                        minute = "0";
                    }
                    
                    for(int i = 0; i < appointments.size(); i++)
                    {
                        if(appointments.get(i).occursOn(year, month, day, Integer.parseInt(hour), Integer.parseInt(minute)))
                        {
                            create = false;
                            description.setText("CONFLICT");
                            break;
                        }
                    }
                    
                    if(create)
                    {
                        Appointment newAppointment = new Appointment(year, month, day, Integer.parseInt(hour), Integer.parseInt(minute), description.getText());
                        description.setText("");
                        System.out.println(newAppointment.print());
                        appointments.add(newAppointment);
                    }
                    getTodaysAppointments();
                }
            }
        }
        createButton.addActionListener(new Listener());
        subActionPanelB.add(createButton);
    }

    /**
     * create the cancel button
     */
    private void createCancelButton()
    {
        cancelButton = new JButton("Cancel");
        class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent evt)
            {
                int year = date.get(Calendar.YEAR);
                int month = date.get(Calendar.MONTH);
                int day = date.get(Calendar.DAY_OF_MONTH);
                String hour = hourInput.getText();
                String minute = minuteInput.getText();
                if(hour.equals(""))
                {
                    description.setText("ERROR");
                }
                else
                {
                    if(minute.equals(""))
                    {
                        minute = "0";
                    }
                    for(int i = 0; i < appointments.size(); i++)
                    {
                        if(appointments.get(i).occursOn(year, month, day, Integer.parseInt(hour), Integer.parseInt(minute)))
                        {
                            appointments.remove(i);
                            break;
                        }
                    }
                    getTodaysAppointments();
                }
            }
        }
        cancelButton.addActionListener(new Listener());
        subActionPanelB.add(cancelButton);
    }
    
    
    /**
     * creates the description subpanel
     */
    private void createDescriptionSubpanel()
    {
        descriptionBorder = new TitledBorder("Description");
        descriptionBorder.setTitleJustification(TitledBorder.LEFT);
        descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBorder(descriptionBorder);
        
        description = new JTextArea(4, 10);
        descriptionPanel.add(description, BorderLayout.CENTER);
        controlPanel.add(descriptionPanel, BorderLayout.SOUTH);
    }
}
