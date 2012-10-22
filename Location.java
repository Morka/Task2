import java.util.HashMap;

public class Location{
	
	private HashMap<String, String> placeDescriptions;
	
	public Location(){
		placeDescriptions = new HashMap<String, String>();
	}
	
	public void addDescription(String nameOfDescription, String description){
		nameOfDescription = nameOfDescription.toLowerCase();
		
		placeDescriptions.put(nameOfDescription, description);			
	}
	
	public String searchDescription(String nameOfDescription){
		String description = "Not Found";
		nameOfDescription = nameOfDescription.toLowerCase();
		
		
		if(placeDescriptions.containsKey(nameOfDescription)){
			description = placeDescriptions.get(nameOfDescription);
		}
		
		return description;
	}
}
