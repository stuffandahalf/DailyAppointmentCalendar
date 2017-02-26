//Name: Gregory Norton
//Student ID: 500766165
//Class: CPS 209


import java.util.Calendar;
import java.util.GregorianCalendar;

public class Appointment implements Comparable
{
	private Calendar date;
    private String description;
    
    public Appointment(int year, int month, int day, int hour, int minute, String description)
    {
        date = new GregorianCalendar(year, month, day, hour, minute);
        this.description = description;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String newDescription)
    {
        description = newDescription;
    }
    
    public Calendar getDate()
    {
        return date;
    }
    
    public void setDate(int year, int month, int day, int hour, int minute)
    {
        date = new GregorianCalendar(year, month, day, hour, minute);
    }
    
    public String print()
    {
        String hour = Integer.toString(date.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(date.get(Calendar.MINUTE));
        return hour + ':' + minute + ' ' + description;
    }
    
    public boolean occursOn(int year, int month, int day, int hour, int minute)
    {
        Calendar otherDate = new GregorianCalendar(year, month, day, hour, minute);
        return date.compareTo(otherDate) == 0;
    }
    
    public int compareTo(Object other)
    {
        Appointment other2 = (Appointment) other;
        return date.compareTo(other2.getDate());
        
    }
}

