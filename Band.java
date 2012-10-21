import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/*
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Band {
	
	private ArrayList<Member> memberList = new ArrayList<Member>();
	private ArrayList<Event> eventList = new ArrayList<Event>(); 
	private ArrayList<Song> songList = new ArrayList<Song>();
	
	public Band(){
	
	}
	
	/**
	 * Adds a member to the member ArrayList
	 * 
	 * @param newMember	a new member object
	 */
	
	public void addMember(Member newMember){
		
		this.memberList.add(newMember);
		
	}
	
	/**
	 * Adds an event to the event ArrayList
	 * 
	 * @param newEvent	a new event object
	 */
	public void addEvent(Event newEvent){
		
		this.eventList.add(newEvent);
		
	}
	
	/**
	 * Adds a song to the repertoire ArrayList
	 * 
	 * @param newSong	a new song for the bands repertoire
	 */
	public void addTrack(Song newSong){
		
		this.songList.add(newSong);
		
	}
	
	/**
	 * Shows Rehearsals on one specific Date
	 * 
	 * @param: Specified Date	a date on which rehearsals should happen
	 * @return: retString (String which contains Rehearsals taking place at the time or null)
	 */
 
	public String showRehearsals(Calendar specificDate){
		
		String retString = "";
		
		Calendar newCal = Calendar.getInstance();
		newCal.setTime(specificDate.getTime());
		
		retString = showRehearsals(specificDate, newCal);
		
		return retString;
		
	}
	
	
	/**
	 * Shows Rehearsals in a given time Period
	 * 
	 * @param: fromDate, toDate	two calendar objects which make a timespan in wich rehearsals should happen
	 * @return: retString (String which contains Rehearsals taking place in the time Period or null)
	 */
	public String showRehearsals(Calendar fromDate, Calendar toDate){		
		String retString = "";

		fromDate.add(Calendar.DAY_OF_MONTH, -1); 
		toDate.add(Calendar.DAY_OF_MONTH, 1);
		
		for(Event r : this.eventList){
			
			if(r instanceof Rehearsal && (r.getDate().after(fromDate) && r.getDate().before(toDate))) {
				
				retString = retString + r.toString() + "\n";
				
			}
			
		}
		
		return retString;
		
	}
	
	/**
	 * Get the specific date and calls another method inside the class to create a return string
	 * 
	 * @param specificDate	a single date where a gig should happen
	 * @return	returns a string with a list of all the gigs on specific date
	 */
	public String showGigs(Calendar specificDate){
		
		String retString = "";
		
		retString = showGigs(specificDate, specificDate);
		
		return retString;
		
	}
	
	/**
	 * Uses two dates to get the Gigs from the specified timespan.
	 * 
	 * @param fromDate	beginn of the timespan
	 * @param toDate	end of the timespan
	 * @return			a printable string representation of the gigs
	 */
	public String showGigs(Calendar fromDate, Calendar toDate){
		
		String retString = "";
		fromDate.add(Calendar.DAY_OF_MONTH, -1);
		toDate.add(Calendar.DAY_OF_MONTH, 1);
		
		for(Event r : this.eventList){
			
			if(r instanceof Gig && (r.getDate().after(fromDate) && r.getDate().before(toDate))) {
				
				retString = retString + r.toString() + "\n";
				
			}
			
		}
		
		return retString;
		
	}
	
	
	/**
	 * Gets all events from a specified timespan and returns a printable string representation.
	 * 
	 * @param from	beginn date of the timespan
	 * @param to	end date of the timespan
	 * @return		a printable string representation of the events
	 */
	public String showEvents(Calendar from, Calendar to){
	
		/*String retString = "Rehearsals: \n";
		retString = retString + this.showRehearsals(from, to);
		
		retString = retString + "Gigs: \n";
		retString = retString + this.showGigs(from, to);
		
		return retString;*/
		
		String retString = "";
		from.add(Calendar.DAY_OF_MONTH, -1);
		to.add(Calendar.DAY_OF_MONTH, 1);

		for(Event e : this.eventList){

			if(e.getDate().after(from) && e.getDate().before(to)) {

				retString = retString + e.toString() + "\n";

			}

		}
		
		return retString;
		
	}
	
	/**
	 * Creates a printable string of members at a specific date
	 * 
	 * @param specificDate	the date when you want to get the member of the band
	 * @return				a printable string of all the members
	 */
	public String showMember(Calendar specificDate){
		
		String retString = "";
		
		for(Member m : this.memberList){
			
			if(m.getEntryDate().before(specificDate) && (m.getExitDate().after(specificDate) || m.getExitDate() == null)) {
				
				retString = retString + m.toString() + "\n";
				
			}
			
		}
		
		return retString;
		
	}
	
	/**
	 * Shows the songs the band is able to play during a specified timeframe
	 * 
	 * @param fromDate	beginn date of the timeframe
	 * @param toDate	end date of the timeframe
	 * @return			a printable representation of all the songs the band is able to play
	 */
	public String showSongs(Calendar fromDate, Calendar toDate){
		
		String retString = "";
		fromDate.add(Calendar.DAY_OF_MONTH, -1);
		toDate.add(Calendar.DAY_OF_MONTH, 1);
		
		for(Song r : this.songList){
			
			if(r.getEndDate() == null && (r.getStartDate().after(fromDate) && r.getStartDate().before(toDate))) {
				
				retString = retString + r.toString() + "\n";
				
			}
			else if(r.getEndDate() != null && (r.getStartDate().after(fromDate) && r.getEndDate().before(toDate))){
				retString = retString + r.toString() + "\n";
			}
			
		}
		
		return retString;
		
	}
	
	/**
	 * Takes and old and a new event. Adds the old event to the oldEvent ArrayList and sets it in the new event
	 * 
	 * @param originalEvent	the original event we want to update
	 * @param newEvent		the new event with the updated information
	 */
	public void updateEvent(Event originalEvent, Event newEvent){
		
		ArrayList<Event> tmpList;
		
		for(Event e : this.eventList){
			
			if(e == originalEvent){
				
				tmpList = e.getPreviousEvents(); //can that work as intended???? Oo
				tmpList.add(originalEvent); //Ideas for deleted once? flag them as such?
				newEvent.setPreviousEvents(tmpList);
				e = newEvent;
				
			}
			
		}
		
	}
	
	/**
	 * Uses the undoEvent and the undoLevel to get a previous state of an event and undo the changes
	 * 
	 * @param undoEvent	the event we want to undo a change
	 * @param undoLevel	the level we want to undo
	 */
	public void undoEventChange(Event undoEvent, int undoLevel){
		
		ArrayList<Event> tmpList;
		Event tmpEvent;
		
		for(Event e: this.eventList){ //and what about that??? 
			
			if(e == undoEvent){
				
				tmpList = e.getPreviousEvents();
				tmpEvent = tmpList.get(undoLevel);
				tmpList.remove(undoLevel);
				tmpEvent.setPreviousEvents(tmpList);
				e = tmpEvent;
				
			}
			
		}
		
	}
	
}
