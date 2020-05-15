package service_layer_players;

import service_layer_cards.Card;
import service_layer_cards.WayCard;
import service_layer_physics.Deck;
import service_layer_physics.Game;

import java.util.ArrayList;

public abstract class Player {

	protected static int id = -1;

	private int score = 0;
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	protected String type = "None";
	
	protected String dwarfName;
	
	private ArrayList<String> handByTypes = new ArrayList<String>();

	public String getDwarfName() {
		return dwarfName;
	}

	public void setDwarfName(String dwarfName) {
		this.dwarfName = dwarfName;
	}

	public int getTheScore() {
		return score;
	}
	
	public void setTheScore(int num) {
		this.score = num;
	}
	
	public void addToTheScore() {
		//score++;
		score++;
	}
	
/*
 * Letrehoz egy uj jatekost, es ID-t rendel hozza.
 */
	public Player() {
		id++;
	}
	
	
/*
 * Visszaadja egy jatekos kezeben levo kartyakat lista formatumban.
 */
	public ArrayList<Card> getHand(){
		return hand;
	}


	public ArrayList<String> getHandByTypes(){
		
		for (Card cd : hand) {
			if(cd.getClass() == (new WayCard()).getClass()) {
				WayCard wc = (WayCard) cd;
				handByTypes.add("" + wc.getWayCardType());
			}
			else handByTypes.add("" + cd.getCardType());
		}
		return handByTypes;
	}
	
/*
 * Visszaad egy kartyat a kezbol (az indexevel kell ra hivatkozni).
 */
	public Card getOneCardFromHand(int indexOfCard) {
		return hand.get(indexOfCard);
	}
	
/*
 * Egy kartya hasznalata (visszaadja + kiveszi a kezbol).	
 */
	public Card useOneCardFromHand(int indexOfCard) {
		Card used = hand.get(indexOfCard);
		hand.remove(indexOfCard);
		return used;
	}
	
	public Card useOneCardFromHand(Card cd) {
		Card used = cd;
		hand.remove(cd);
		return used;
	}
	
/*
 * Minden lapot eldobunk a kezbol, ures kezet csinal.
 */
	public void cleanHand() {
		hand.clear();
	}
	
/*
 * Visszaadja hogy egy jatekos saboteur vagy aranyaso-e.
 */
	public String getType() {
		return type;
	}
	
/*
 * Huzunk egy lapot egy paklibol (Deck), es a kezunkbe vesszuk.
 */
	public Card pickACard() {
		if(hand.size() < Game.getMaxCardsInHand() && Deck.getDeckSize() > 0) {
						Card cd = Deck.getRandCard();
						hand.add(cd);
						return cd;
				}
		else return null;
	}
	
/*
 * A jatek elejen automatikusan kioszt a kezunkbe annyi lapot, ahany a jatekosok szama szerint maximalisan a kezunkben lehet.
 */
	public void setHand() {
				for(int i = 0; i < Game.getMaxCardsInHand(); i++)
				{
					hand.add(Deck.getRandCard());
				}	
		}
}