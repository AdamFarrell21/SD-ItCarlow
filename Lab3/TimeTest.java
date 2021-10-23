package lab3;
import java.util.Calendar;

//Driver program to test the Time class.
public class TimeTest
{
	static Calendar cal = Calendar.getInstance ();
	
	
	public static void main (String args[])
	{
		Time t = new Time (cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		System.out.println(t.toMilitaryString());
		System.out.println(t.toString());
		System.out.println(t.toMilitaryString());
		System.out.println(t.toString());
		System.out.print("Current time in milliseconds = ");
		System.out.println(System.currentTimeMillis());
		
	}


}
