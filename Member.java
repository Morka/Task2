import java.util.Calendar;
import java.util.ArrayList;

/*
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Member {
	
	private String name, telNr, instrument;
	Calendar enteringDate, exitDate;
	private ArrayList<Song> songList;
	
	public Member(String memberName, String telNumber, String instrument,
				  ArrayList<Song> songs){
		
		this.name = memberName;
		this.telNr = telNumber;
		this.instrument = instrument;
		this.enteringDate = Calendar.getInstance();
		this.songList = new ArrayList<Song>(songs);
	}
	
	public void memberExit(){
		
		this.exitDate = Calendar.getInstance();
		
	}
	
	public Calendar getEntryDate(){
		
		return this.enteringDate;
		
	}
	
	public Calendar getExitDate(){
		
		return this.exitDate;
		
	}
	
	/*
	 *	Adds a song to the Repertoire of the Member
	 */
	public void addSongToList(Song song){
		songList.add(song);
	}
	
	/*
	 * Gets the List of Songs, the member can play
	 */
	
	public ArrayList<Song> getSongsList(){
		return songList;
	}
	
	public String toString(){
		return "Name: " + name + ", Instrument: " + instrument;
	}

}
