package service_layer_cards;

public abstract class Card {

	private static int counter = -1;
	protected int cardID;
	protected CardType cardType;
		
	/**
	 * Letrehoz egy Card-ot, es ad neki egy ID-t, melyet a getCardID() metodussal kerhetunk le.
	 */
	
	public Card() {
		this.cardType = CardType.EMPTY;
		counter++;
		cardID = counter;
	}
	
	/**
	 * Visszaadja egy kartya tipusat (Enum).
	 * @return kartya tipusa
	 */
	public CardType getCardType() {
		return cardType;
	}

	/**
	 * Visszaadja egy kartya szemelyes azonositojat, amellyel hivatkozni lehet ra.
	 */
	public int getCardID() {
		return cardID;
	}
	
	/**
	 * Elolrol kezdi a lapok szamozasat.
	 */
	public static void setCounterBack() {
		counter = -1;
	}
}
