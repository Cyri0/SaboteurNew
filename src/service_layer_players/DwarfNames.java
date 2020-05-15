package service_layer_players;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class  DwarfNames {

	private static ArrayList<String> oldDwarfNames = new ArrayList<>(
			Arrays.asList("Balin","Bifur","Bofur","Bombur","Dori","Dwalin","Fíli","Glóin","Kíli","Thorin","Óin","Ori","Nori"));
	private static ArrayList<String> dwarfNames = new ArrayList<>(
			Arrays.asList("Balin","Bifur","Bofur","Bombur","Dori","Dwalin","Fíli","Glóin","Kíli","Thorin","Óin","Ori","Nori"));
	
	public static String getRandNameFromList() {
		int max = dwarfNames.size();
		int min = 0;
		
		int random = ((int) (Math.random() * max))+min;
		String name = dwarfNames.get(random);
		dwarfNames.remove(random);
		
		return name;
	}
	
	public static ArrayList<String> getTheNameList() {
		
		return oldDwarfNames;
	}
	
	public static void fillNamesAgain() {
		
		dwarfNames = oldDwarfNames;
	}
}
