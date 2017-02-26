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
        super();                                                                        //call superclass constructor
        date = new GregorianCalendar();                                                 //initialize variable date as a pointer to a new GregorianCalendar object
        sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");                                //initialize variable sdf as a pointer to a new SimpleDateFormat
        appointments = new ArrayList<Appointment>();                                    //initialize appointments as a pointer to a new ArrayList for storing Appointment objects
        
        createLabel();                                                                  //run createLabel method
        createTextArea();                                                               //run createTextArea method
        createControlPanel();                                                           //run createControlPanel method
        
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);                                           //sets the size of the JFrame to the constants WINDOW_WIDTH and WINDOW_HEIGHT
        setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));                     //sets the minimum size of the JFrame to the same constants
    }
    
    /**
     * method to create JLabel for frame
     */
    private void createLabel()
    {
        dateLabel = new JLabel(sdf.format(date.getTime()));                             //initializes the dateLabel variable to point to a new JLabel object which displays the current date
        add(dateLabel, BorderLayout.NORTH);                                             //add the label object to the north part of the JFrame
    }
    
    
    /**
     * method to create main text area
     */
    private void createTextArea()
    {
        textArea = new JTextArea();                                                     //initialize the textArea as a pointer to a new JTextArea object
        textArea.setEditable(false);                                                    //disable editing the text in the JTextArea
        scrollPane = new JScrollPane(textArea);                                         //create a new JScrollPane fromm the JTextArea to make it scrollable
        add(scrollPane, BorderLayout.CENTER);                                           //add the scrollPane to the center of the JFrame
    }
    
    
    /**
     * method to create control panel of the frame
     */
    private void createControlPanel()
    {
        controlPanel = new JPanel(new BorderLayout());                                  //create a new panel for the control panel
        createDateSubpanel();                                                           //call the createDateSubpanel method
        createActionSubpanel();                                                         //call the createActionSubpanel method
        createDescriptionSubpanel();                                                    //call the createDescriptionSubPanel method
        
        add(controlPanel, BorderLayout.SOUTH);                                          //add the controlPanel to the south of the JFrame
    }
    
    
    /**
     * create the subpanel to adjust the date
     */
    private void createDateSubpanel()
    {
        dateBorder = new TitledBorder("Date");                                          //create a new TitledBorder for the datePanel with title Date
        dateBorder.setTitleJustification(TitledBorder.LEFT);                            //set the justification of the title to the left
        datePanel = new JPanel(new BorderLayout());                                     //create a new subpanel for the date controls
        datePanel.setBorder(dateBorder);                                                //set the border of the panel to the titleborder
        
        subDatePanelA = new JPanel(new GridLayout(1, 2));                               //create a subpanel with the a 1x2 gridlayout to contain the left and right buttons
        datePanel.add(subDatePanelA, BorderLayout.NORTH);                               //add the subpanel to the main datePanel
        createLeftButton();                                                             //call the createLeftButton method
        createRightButton();                                                            //call the createRightButton method
        
        subDatePanelB = new JPanel();                                                   //create another subpanel with the flow layout to store the inputs and labels
        
        dayLabel = new JLabel("Day");                                                   //initialize the dayLabel as a pointer to a new JLabel object with label Day
        subDatePanelB.add(dayLabel);                                                    //add the label to the subpanel
        dayInput = new JTextField(Integer.toString(date.get(Calendar.DAY_OF_MONTH)), 2);//initialize the dayInput as a pointer to a new JTextField with default text of the current day and a size of 2 columns
        subDatePanelB.add(dayInput);                                                    //add the dayinput to the subpanel
        
        monthLabel = new JLabel("Month");                                               //initialize the monthLabel as a pointer to a new JLabel object with label Month
        subDatePanelB.add(monthLabel);                                                  //add the label to the subpanel
        monthInput = new JTextField(Integer.toString(date.get(Calendar.MONTH)+1), 2);   //initialize the monthInput as a pointer to a new JTextField with default text of the current month and a size of 2 columns
        subDatePanelB.add(monthInput);                                                  //add the monthInput to the subpanel
        
        yearLabel = new JLabel("Year");                                                 //initialize the monthLabel as a pointer to a new JLabel object with label Year
        subDatePanelB.add(yearLabel);                                                   //add the label to the subpanel
        yearInput = new JTextField(Integer.toString(date.get(Calendar.YEAR)), 4);       //initialize the yearInput as a pointer to a new JTextField with default text of the current year and a size of 4 columns
        subDatePanelB.add(yearInput);                                                   //add the yearInput to the subpanel
        datePanel.add(subDatePanelB, BorderLayout.CENTER);                              //add the subpanel to the datePanel
        
        subDatePanelC = new JPanel();                                                   //create another subpanel for the show button
        createShowButton();                                                             //call the createShowButton method
        datePanel.add(subDatePanelC, BorderLayout.SOUTH);                               //add the subpanel to the datePanel
        
        controlPanel.add(datePanel, BorderLayout.NORTH);                                //add the datePanel to the north of the controlPanel
    }
    
    /**
     * create the left button
     */
    private void createLeftButton()
    {
        class Listener implements ActionListener                                        //create a subclass to implement the ActionListener interface
        {
            public void actionPerformed(ActionEvent evt)                                //override the actionPerformed method
            {
                date.add(Calendar.DAY_OF_MONTH, -1);                                    //add -1 days to the current date
                dateLabel.setText(sdf.format(date.getTime()));                          //set the content of the dateLabel to be the new date
                getTodaysAppointments();                                                //run the getTodaysAppointments method
            }
        }
        
        leftButton = new JButton("<");                                                  //initialize the leftButton to point to a new JButton object with label <
        leftButton.addActionListener(new Listener());                                   //add the new listener class to the button
        
        subDatePanelA.add(leftButton);                                                  //add the leftButton to the first date subpanel
    }
    
    /**
     * create the right button
     */
    private void createRightButton()
    {
        class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent evt)                                //create a subclass to implement the ActionListener interface
            {
                date.add(Calendar.DAY_OF_MONTH, 1);                                     //add 1 day to the current date
                dateLabel.setText(sdf.format(date.getTime()));                          //set the content of the dateLabel to be the new date
                getTodaysAppointments();                                                //run the getTodaysAppointments method
            }
        }
        
        rightButton = new JButton(">");                                                 //initialize the rightButton to point to a new JButton object with label >
        rightButton.addActionListener(new Listener());                                  //add the new listener class to the button
        
        subDatePanelA.add(rightButton);                                                 //add the rightButton to the first date subpanel
    }
    
    /**
     * create the show button
     */
    private void createShowButton()
    {
        showButton = new JButton("Show");                                               //set the showButton to point to a new JButton with label Show
        class Listener implements ActionListener                                        //subclass that implements the ActionListener interface
        {
            public void actionPerformed(ActionEvent evt)                                //override the actionPerformed method
            {                
                String year = yearInput.getText();                                      //get the provided year from the textField
                if(!year.equals(""))                                                    //if the provided year isnt blank
                {
                    date.set(Calendar.YEAR, Integer.parseInt(yearInput.getText()));     //set the current year to the one provided
                }
                String month = monthInput.getText();                                    //repeat the same steps for month and day
                if(!month.equals(""))
                {
                    date.set(Calendar.MONTH, Integer.parseInt(monthInput.getText())-1);
                }
                String day = dayInput.getText();
                if(!day.equals(""))
                {
                    date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dayInput.getText()));
                }
                yearInput.setText(Integer.toString(date.get(Calendar.YEAR)));           //set the text in the textFields for the year
                monthInput.setText(Integer.toString(date.get(Calendar.MONTH)+1));       //month, and day to represent the current date
                dayInput.setText(Integer.toString(date.get(Calendar.DAY_OF_MONTH)));
                dateLabel.setText(sdf.format(date.getTime()));                          //set the text of the dateLabel to the current date
                getTodaysAppointments();                                                //run getTodaysAppointments to show the appointments for that date
            }
        }
        showButton.addActionListener(new Listener());                                   //add the actionListener to the showButton
        subDatePanelC.add(showButton, BorderLayout.CENTER);                             //add the showButton the the third date subpanel
    }
    
    /**
     * method to get and print the
     * appointments for the day to
     * the JTextArea
     */
    private void getTodaysAppointments()
    {
        textArea.setText("");                                                           //clear the textArea of all old appointments
        Collections.sort(appointments);                                                 //sort the appointments ArrayList
        for(int i = 0; i < appointments.size(); i++)                                    //for every index in the ArrayList
        {
            Calendar apptDate = appointments.get(i).getDate();                          //get the date of the appointment
            if(apptDate.get(Calendar.YEAR) == date.get(Calendar.YEAR) &&                //if the current date is equal to the date of the appointment
               apptDate.get(Calendar.MONTH) == date.get(Calendar.MONTH) &&
               apptDate.get(Calendar.DAY_OF_MONTH) == date.get(Calendar.DAY_OF_MONTH))
            {
                textArea.append(appointments.get(i).print());                           //add the appointment to the textArea
                textArea.append("\n\n");                                                //add two newlines to the textArea
            }
        }
    }
 
    
    
    /**
     * create the subpanel for the actions
     */
    private void createActionSubpanel()
    {
        actionBorder = new TitledBorder("Action");                                      //create a new TitledBorder with title Action
        actionBorder.setTitleJustification(TitledBorder.LEFT);                          //set the justification for the title to left
        actionPanel = new JPanel(new BorderLayout());                                   //create a new JPanel
        actionPanel.setBorder(actionBorder);                                            //set the border of the new JPanel to the new border
        
        subActionPanelA = new JPanel();                                                 //create a subpanel
        hourLabel = new JLabel("Hour");                                                 //set the hourLabel to point to a new JLabel object with label Hour
        subActionPanelA.add(hourLabel);                                                 //add the hourLabel to the subpanel
        hourInput = new JTextField(2);                                                  //create a new JTextField object with 2 columns
        subActionPanelA.add(hourInput);                                                 //add the hourInput to the subpanel
        minuteLabel = new JLabel("Minute");                                             //repeat this for minutes
        subActionPanelA.add(minuteLabel);
        minuteInput = new JTextField(2);
        subActionPanelA.add(minuteInput);
        actionPanel.add(subActionPanelA, BorderLayout.NORTH);                           //add the subpanel to the north of the main actionPanel
        
        subActionPanelB = new JPanel();                                                 //make another subpanel
        createCreateButton();                                                           //run the createCreateButton method
        createCancelButton();                                                           //run the createCancelButton method
        actionPanel.add(subActionPanelB, BorderLayout.CENTER);                          //add the subpanel to the main actionPanel
        
        controlPanel.add(actionPanel, BorderLayout.CENTER);                             //add the actionPanel to the controlPanel
    }
    
    /**
     * create the create button
     */
    private void createCreateButton()
    {
        createButton = new JButton("Create");                                           //create a new JButton with label Create
        class Listener implements ActionListener                                        //make a subclass that implements the ActionListener interface
        {
            public void actionPerformed(ActionEvent evt)                                //override the actionPerformed method
            {
                boolean create = true;                                                  //boolean to store wheather the appointment should be made or not
                int year = date.get(Calendar.YEAR);                                     //easy access to the year,
                int month = date.get(Calendar.MONTH);                                   //month,
                int day = date.get(Calendar.DAY_OF_MONTH);                              //and day
                
                String hour = hourInput.getText();                                      //get the hour from the hourInput JTextField
                String minute = minuteInput.getText();                                  //get the minute from the minuteInput JTextField
                if(hour.equals(""))                                                     //if the given hours are blank
                {
                    description.setText("ERROR");                                       //set the description box to say ERROR
                }
                else                                                                    //otherwise
                {
                    if(minute.equals(""))                                               //if the given minutes are blank
                    {
                        minute = "0";                                                   //set minutes to 0
                    }
                    
                    for(int i = 0; i < appointments.size(); i++)                        //for every index in appointments
                    {
                        if(appointments.get(i).occursOn(year, month, day, Integer.parseInt(hour), Integer.parseInt(minute)))    //check if the appointment occurs at the given time
                        {
                            create = false;                                             //set the create variable to false
                            description.setText("CONFLICT");                            //set the text of the description box to say CONFLICT
                            break;                                                      //break the loop
                        }
                    }
                    
                    if(create)                                                          //if create was not set to false
                    {
                        Appointment newAppointment = new Appointment(year, month, day, Integer.parseInt(hour), Integer.parseInt(minute), description.getText());    //make a new appointment at the given time
                        description.setText("");                                        //clear the description text box
                        appointments.add(newAppointment);                               //add the new appointment to the ArrayList
                    }
                    getTodaysAppointments();                                            //run the getTodaysAppointments method to print them to the screen
                }
            }
        }
        createButton.addActionListener(new Listener());                                 //add the new ActionListener to the JButton
        subActionPanelB.add(createButton);                                              //add the createbutton to the second action subpanel
    }

    /**
     * create the cancel button
     */
    private void createCancelButton()
    {
        cancelButton = new JButton("Cancel");                                           //create a new JButton with label Cancel
        class Listener implements ActionListener                                        //create a subclass that implements the ActionListener interface
        {
            public void actionPerformed(ActionEvent evt)                                //override the actionPerformed method
            {
                int year = date.get(Calendar.YEAR);                                     //store the current year,
                int month = date.get(Calendar.MONTH);                                   //month,
                int day = date.get(Calendar.DAY_OF_MONTH);                              //and day
                String hour = hourInput.getText();                                      //get the hour from the hourInput textField
                String minute = minuteInput.getText();                                  //get the minute from the minnuteInput textField
                if(hour.equals(""))                                                     //if there was no hour specified
                {
                    description.setText("ERROR");                                       //set the description box to ERROR
                }
                else                                                                    //otherwise
                {
                    if(minute.equals(""))                                               //if there was no minute specified
                    {
                        minute = "0";                                                   //set the minutes to 0
                    }
                    for(int i = 0; i < appointments.size(); i++)                        //for every index in the ArrayList
                    {
                        if(appointments.get(i).occursOn(year, month, day, Integer.parseInt(hour), Integer.parseInt(minute)))    //if the appointment occurs on the given time
                        {
                            appointments.remove(i);                                     //remove the appointment from the arrayList
                            break;                                                      //break the loop
                        }
                    }
                    getTodaysAppointments();                                            //run the getTodaysAppointments method to display the remaining appointments
                }
            }
        }
        cancelButton.addActionListener(new Listener());                                 //add the ActionListener to the cancelButton
        subActionPanelB.add(cancelButton);                                              //add the cancelButton to the second action subpanel
    }
    
    
    /**
     * creates the description subpanel
     */
    private void createDescriptionSubpanel()
    {
        descriptionBorder = new TitledBorder("Description");                            //create a new TitledBorder with title Description
        descriptionBorder.setTitleJustification(TitledBorder.LEFT);                     //set the justification for the title to left
        descriptionPanel = new JPanel(new BorderLayout());                              //create a new JPanel with the BorderLayout
        descriptionPanel.setBorder(descriptionBorder);                                  //set the border for the panel to the TitledBorder
        
        description = new JTextArea(4, 10);                                             //create a new JTextArea with 4 rows and 10 columns
        descriptionPanel.add(description, BorderLayout.CENTER);                         //add the description JTextArea to the center of the descriptionPanel
        controlPanel.add(descriptionPanel, BorderLayout.SOUTH);                         //add the descriptionPanel to the south of the controlPanel
    }
}
