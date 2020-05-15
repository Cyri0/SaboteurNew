package service_layer_physics;

import java.util.ArrayList;
import java.util.Random;

import service_layer_cards.Card;
import service_layer_cards.MapCard;
import service_layer_cards.WayCard;

public class Deck {

	protected static ArrayList<Card> cardDeck = new ArrayList<Card>();

	public static void fillTheDeckWithBasic() {
		
		for(int i = 0; i < 5; i++)
			Deck.fillTheDeck(new WayCard(1));
		
		for(int i = 0; i < 5; i++)
			Deck.fillTheDeck(new WayCard(2));
		
		for(int i = 0; i < 5; i++)
			Deck.fillTheDeck(new WayCard(3));
		
		for(int i = 0; i < 5; i++)
			Deck.fillTheDeck(new WayCard(4));
		
		for(int i = 0; i < 5; i++)
			Deck.fillTheDeck(new WayCard(5));
		
		for(int i = 0; i < 5; i++)
			Deck.fillTheDeck(new WayCard(6));
		
		for(int i = 0; i < 5; i++)
			Deck.fillTheDeck(new WayCard(7));
		
		for(int i=0; i < 3; i++)
			Deck.fillTheDeck(new MapCard());
	}
	
	
/*
 * Megkap egy Card-ot es ezt belerakja a pakliba.
 */
	public static void fillTheDeck(Card cd) {
		cardDeck.add(cd);
	}
	
/*
 * Kidobja a paklit, ures pakli listat kapunk.
 */
	public static void cleanTheDeck() {
		cardDeck.clear();
	}
	
/*
 * Egy veletlen lapot huzhatunk a paklibol.
 */
	public static Card getRandCard(){

		Random rn = new Random();
		
		if(cardDeck.size() > 0) {
			int choosenOne = 0 + rn.nextInt(cardDeck.size());
			Card cd = cardDeck.get(choosenOne);
			cardDeck.remove(cardDeck.get(choosenOne));			
			return cd;
		}
		return null;
	}

/*
 * Visszakapjuk az egesz pakli kartyat, lista formatumban.
 */
	public static ArrayList<Card> getTheDeck(){
		return cardDeck;
	}
	
/*
 * Visszakapjuk hany kartya van a pakliban.
 */
	public static int getDeckSize() {
		return cardDeck.size();
	}
}