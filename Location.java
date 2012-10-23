import java.util.HashMap;
import java.util.ArrayList;

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
	
	public boolean neededInfrastructure(ArrayList<String> neededInfrastracture){
		boolean hasEverything = true;
		
		if(neededInfrastracture == null){
			return false;
		}
		
		for(String s : neededInfrastracture){
			if(!placeDescriptions.containsKey(s.toLowerCase){
				hasEverything = false;	
			}					
		}
		
		return hasEverything;
	}
}
