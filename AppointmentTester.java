public class AppointmentTester
{
	public static void main (String args[])
    {
		Appointment test = new Appointment(2017, 02, 20, 17, 31, "this is a test");
        System.out.println(test.print());
        System.out.println(test.occursOn(2015, 1, 1, 1, 1));
        System.out.println(test.occursOn(2017, 02, 20, 17, 31));
        Appointment test2 = new Appointment(2015, 02, 20, 17, 31, "this is another test");
        System.out.println(test2.print());
        Appointment test3 = new Appointment(2013, 1, 1, 1, 1, "this is a third test");
        System.out.println(test3.print());
        System.out.println(test.compareTo(test));
	}
}

