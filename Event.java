import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/*
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public abstract class Event{
	
	private int duration; //duration of the Event
	private String location; //location of the Event
	private Calendar date; //date AND time of the Event
	private ArrayList<Member> member; //member who are playing at this Event
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	
	public Event(int duration, String location, Calendar date, ArrayList<Member> member){
		this.duration = duration;
		this.location = location;
		this.date = date;
		this.member = new ArrayList<Member>(member);
	}
	
	public String getLocation(){
		return location;
	}
	
	
	public int getDuration(){
		return duration;
	}
	
	public void setDate(Calendar date){
		this.date = date;
	}	
	
	public Calendar getDate(){
		return date;
	}
	
	public ArrayList<Song> getListOfSongsPlayable(){
		ArrayList<Song> playableSongs = new ArrayList<Song>();
		
		Member theOne = member.get(0); //member must not be null!
		
		
		for(int m = 1; m < member.size(); m++){
			if(member.get(m) == null){
				return playableSongs;
			}
			for(int s = 0; s < member.get(m).getSongsList().size(); s++){
				for(int i = 0; i < theOne.getSongsList().size(); i++){
					if(theOne.getSongsList().get(i) == member.get(m).getSongsList().get(s)){
						playableSongs.add(theOne.getSongsList().get(i));
					}
				}
			}
		}
		
		return playableSongs;
	}
	
	public String toString(){
		return "Location: " + location + ", Duration: " + duration + ", Date: " + dateFormat.format(date.getTime());
	}
	
}
