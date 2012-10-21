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
	
	//adds up all miscellaneous costs/revenues for specific category and period
	static public int getMisc(ArrayList<Budget> budgetStack, String category, Calendar fromDate, Calendar toDate)
	{
		int sum = 0;
		Iterator<Budget> it = budgetStack.iterator();
		fromDate.add(Calendar.DAY_OF_MONTH, -1); 
		toDate.add(Calendar.DAY_OF_MONTH, 1);
		
		while(it.hasNext())
		{
			Budget budget = it.next();
			if((budget.getDate().after(fromDate)) && (budget.getDate().before(toDate)) && (category.equals(budget.getCategory())))
				sum += budget.getValue();
		}
		
		return sum;
	}	
	
	//adds up all rents for Events for period
	static public int getRents(ArrayList<Event> events, Calendar fromDate, Calendar toDate)
	{
		int sum = 0;
		Iterator<Event> it = events.iterator();
		fromDate.add(Calendar.DAY_OF_MONTH, -1); 
		toDate.add(Calendar.DAY_OF_MONTH, 1);
		
		while(it.hasNext())
		{
			Event currentEvent = it.next();
			if((currentEvent instanceof Gig) && (currentEvent.getDate().after(fromDate)) && (currentEvent.getDate().before(toDate)))
				sum += ((Gig)currentEvent).getFee();	
		}
		
		return sum;
	}
	
	
	//adds up all fees for Events for period
	static public int getFees(ArrayList<Event> events, Calendar fromDate, Calendar toDate)
	{
		int sum = 0;
		Iterator<Event> it = events.iterator();
		fromDate.add(Calendar.DAY_OF_MONTH, -1); 
		toDate.add(Calendar.DAY_OF_MONTH, 1);
		
		while(it.hasNext())
		{
			Event currentEvent = it.next();
			if((currentEvent instanceof Rehearsal) && (currentEvent.getDate().after(fromDate)) && (currentEvent.getDate().before(toDate)))
				sum += ((Rehearsal)currentEvent).getRent();	
		}
		
		return sum;
	}
}
