package application;

import service_layer_cards.WayCard;

public class SelectedWayCard {

	private static WayCard wc;
	
	public static void set(WayCard selectedWayCard) {
		wc = selectedWayCard;
	}
	
	public static WayCard get() {
		return wc;
	}
}