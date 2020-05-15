package service_layer_cards;

public class GoldCard extends TargetCard{

	private static GoldCard gc = null;
	
	public GoldCard() {
		super();
		this.cardType = CardType.GOLD;
		if(gc == null)
			gc = this;
	}
	
	public static GoldCard getSingleton() {
		return gc;
	}
}
