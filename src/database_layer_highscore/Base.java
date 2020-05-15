package database_layer_highscore;

import java.util.ArrayList;

public class Base {

	
	private static ArrayList<DataPlayer> miners = new ArrayList<DataPlayer>();
	
	public static void add(String name, int score) {
		DataPlayer dp= new DataPlayer(score, name);
		miners.add(dp);
	}

	public static ArrayList<DataPlayer> get() {
		return miners;
	}
	
	public static void clear() {
		miners.clear();
	}
	

	public static DataPlayer getElement(int i) {
		return miners.get(i);
	}	
}
