import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class Budget {
	private String budgetname;
	private Calendar date;
	private int value;
		
	public Budget(String budgetname,int value)
	{
		this.budgetname = budgetname;
		this.value = value;
		this.date = Calendar.getInstance();
	}
	
	public String getCategory()
	{
		return budgetname;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public Calendar getDate()
	{
		return date;
	}
	
}
