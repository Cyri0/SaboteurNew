package service_layer_cards;

public class MapCard extends Card{

	/**
	 * Uj terkep kartyat hoz letre es beallitja a tipusat is.
	 */
	public MapCard() {
		super();
		
		this.cardType = CardType.MAP;
	}
}