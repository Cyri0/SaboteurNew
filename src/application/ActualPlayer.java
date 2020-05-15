package application;

import service_layer_players.Player;

public abstract class ActualPlayer {

	private static Player actual;
	
	public static void set(Player p) {
		actual = p;
	}
	
	public static Player get() {
		return actual;
	}	
}
