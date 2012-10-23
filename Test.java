import java.util.ArrayList;
import java.util.Calendar;

public class Test{
	public static void main(String[] args){
		Calendar date = Calendar.getInstance();
		
		Band band = new Band();
		
		/*
		 * create locations and store them in the Arraylist of Band
		 */
		
		Location location1 = new Location("WUK");
		Location location2 = new Location("Arena");
		Location location3 = new Location("Posthof");
		Location location4 = new Location("Wiesen");
		
		band.addLocation(location1);
		band.addLocation(location2);
		band.addLocation(location3);
		band.addLocation(location4);
		
		/*
		 * New descriptions are added. location1 and location4 descriptions are 
		 * perfekt while location2 descriptions have wrong cases, which is 
		 * filterd and location3 has a Typo, which can't be filtered by 
		 * the programm. 
		 */ 
		location1.addDescription("Food", "There is a catering");
		location1.addDescription("Equipment", "Nice Equipment is provided");
		location2.addDescription("FoOd", "Lots of delicious food!");
		location2.addDescription("EQUIPMENT", "Pew Pew");
		location3.addDescription("FOOD", "Perfect");
		location3.addDescription("eqipment", "shitty"); //intentional Typo!
		location4.addDescription("Food", "wonderful service");
		location4.addDescription("Equipment", "nice microfones");
		location4.addDescription("Free Beer", "");
		
		/*
		 * toBeFound is the Array which contains the strings which are to be found	
		 */
		
		ArrayList<String> toBeFound = new ArrayList<String>();
		toBeFound.add("Food");
		toBeFound.add("Equipment");
		
		/**
		 * anticipated output: "WUK"
		 					   "Arena"
		 					   "Wiesen"
		 */
		System.out.println("Which Locations suits better?");
		System.out.println(band.searchForInfrastracture(toBeFound));
		
		Song song1 = new Song("With", 132);
		Song song2 = new Song("a little", 212);
		Song song3 = new Song("Help", 21);
		
		band.addTrack(song1);
		band.addTrack(song2);
		band.addTrack(song3);
		
		Member member1 = new Member("John", "13221221", "Guitar");
		Member member2 = new Member("Paul", "13221221", "Bass Guitar");
		Member member3 = new Member("George", "13221223", "Guitar");
		
		band.addMember(member1);
		band.addMember(member2);
		band.addMember(member3);
		
		ArrayList<Member> memberList1 = new ArrayList<Member>();
		memberList1.add(member1);
		memberList1.add(member2);
		memberList1.add(member3);
		
		member1.addSongToList(song1);
		member1.addSongToList(song2);
		member1.addSongToList(song3);
		
		member2.addSongToList(song2);
		member2.addSongToList(song3);
		
		member3.addSongToList(song3);
		
		Gig gig1 = new Gig(2500, location1, date, 2000000, memberList1);
		
		/**
		 * Anticipated Output: "name: Help, length 21"
		 */
		System.out.println("Songs that are playable");
		System.out.println(gig1.getStringOfSongsPlayable());
	}
}
