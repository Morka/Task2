import java.util.Calendar;

public class Message
{
	String message;
	Calendar date;
	
	public Message(String message)
	{
		this.message = message;
		date = Calendar.getInstance();
	}
}