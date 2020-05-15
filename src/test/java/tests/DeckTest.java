package test.java.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service_layer_cards.Card;
import service_layer_cards.WayCard;
import service_layer_physics.Deck;



class DeckTest {
	
	static Deck d;
	
	@BeforeAll
	static void initialize() {
		d = new Deck();
	}
	
	@Test
	public void testDeckFill() {
		Deck.cleanTheDeck();
		Card.setCounterBack();
		Deck.fillTheDeck(new WayCard()); //ID 0
		Deck.fillTheDeck(new WayCard()); //ID 1
		Deck.fillTheDeck(new WayCard()); //ID 2
		assertEquals(Deck.getTheDeck().size(), 3, "AnnyiElemVanAPaklibanAmennyitBeleraktunk");
	}
	
	@Test
	public void putCardFromDeckCardNumCheck() {
		Deck.cleanTheDeck();
		Card.setCounterBack();
		Deck.fillTheDeck(new WayCard()); //ID 0
		Deck.fillTheDeck(new WayCard()); //ID 1
		Deck.fillTheDeck(new WayCard()); //ID 2
		Deck.getRandCard();
		assertEquals(Deck.getTheDeck().size(), 2, "KivettunkEgyElemet");
		Deck.getRandCard();
		assertEquals(Deck.getTheDeck().size(), 1, "KivettunkKetElemet");
		Deck.getRandCard();
		assertEquals(Deck.getTheDeck().size(), 0, "KivettunkMindenElemet");
		Deck.getRandCard();
		assertEquals(Deck.getTheDeck().size(), 0, "TobbElemetVettunkKiMintAmiBenneVolt");
	}
	
	@Test
	public void checkIDIfPutCardFromDeck() {
		Deck.cleanTheDeck();
		Card.setCounterBack();
		Deck.fillTheDeck(new WayCard()); //ID 0
		Deck.fillTheDeck(new WayCard()); //ID 1
		Deck.fillTheDeck(new WayCard()); //ID 2
		
		Card cd = Deck.getRandCard();
		ArrayList<Card> li = Deck.getTheDeck();
		assertEquals(!li.contains(cd), true, "NemTartalmazzaAPakliAKivettLapot");	
	}
}
