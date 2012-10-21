import java.util.Calendar;
import java.util.ArrayList;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Member {
	
	private String name, telNr, instrument;
	private Calendar enteringDate, exitDate;
	private ArrayList<Song> songList;
	
	public Member(String memberName, String telNumber, String instrument){
		
		this.name = memberName;
		this.telNr = telNumber;
		this.instrument = instrument;
		this.enteringDate = Calendar.getInstance();
		this.songList = new ArrayList<Song>();
	}
	
	/**
	 * sets the "exitDate" of the member to the current date
	 *
	 */
	
	public void memberExit(){
		
		this.exitDate = Calendar.getInstance();
		
	}
	
	/**
	 * Gives back a the "enteringDate" of the Member
	 *
	 * @return Calendar
	 */
	
	public Calendar getEntryDate(){
		
		return this.enteringDate;
		
	}
	
	/**
	 * Gives back a the "exitDate" of the Member
	 *
	 * @return Calendar
	 */
	
	public Calendar getExitDate(){
		
		return this.exitDate;
		
	}
	/**
	 *	Adds a song to the Repertoire of the Member
	 */
	public void addSongToList(Song song){
		songList.add(song);
	}
	
	/**
	 * Gets the List of Songs, the member can play
	 */
	public ArrayList<Song> getSongsList(){
		return songList;
	}
	
	public String toString(){
		return "Name: " + name + ", Instrument: " + instrument;
	}

}
