import java.util.ArrayList;

public class Test{
	public static void main(String[] args){
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
		
		
	}
}
