import java.util.HashMap;
import java.util.Calendar;
import java.util.ArrayList;

public class VotingSystem{
	private Calendar date;
	private String explanation;
	private boolean answer;
	
	public VotingSystem(Calendar date, String explanation, boolean answer){
		this.date = date;
		this.explanation = explanation;
		this.answer = answer;
	}
	
	public Calendar getDate(){
		return date;
	}
	public String getExplanation(){
		return explanation;
	}
	public boolean getAnswer(){
		return answer;
	}
}
