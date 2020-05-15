package test.java.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import service_layer_cards.WayCard;
import service_layer_physics.Deck;
import service_layer_physics.Game;
import service_layer_players.Goldminer;
import service_layer_players.Player;
import service_layer_players.Saboteur;

class PlayerTest {

	Player p1 = new Saboteur();
	Player p2 = new Saboteur();
	Player p3 = new Goldminer();

	@Test
	void testSetHand() {
		Game.clearPlayers();
		Game.setPlayerNum(4);
		
		Deck.cleanTheDeck();
		p1.cleanHand();

		Deck.fillTheDeck(new WayCard(1)); // ID 0
		Deck.fillTheDeck(new WayCard(2)); // ID 1
		Deck.fillTheDeck(new WayCard(5)); // ID 2
		Deck.fillTheDeck(new WayCard(2)); // ID 3
		Deck.fillTheDeck(new WayCard(7)); // ID 4
		Deck.fillTheDeck(new WayCard(6)); // ID 5
		Deck.fillTheDeck(new WayCard(5)); // ID 6
		Deck.fillTheDeck(new WayCard(3)); // ID 7
		p1.setHand();

		assertEquals(Deck.getDeckSize(), 2, "SetTheHand");
	}
	
	@Test
	void handTestByType() {
		Game.clearPlayers();
		Game.setPlayerNum(4);
		
		Deck.cleanTheDeck();
		p1.cleanHand();

		Deck.fillTheDeck(new WayCard(1)); // ID 0
		Deck.fillTheDeck(new WayCard(2)); // ID 1
		Deck.fillTheDeck(new WayCard(5)); // ID 2
		Deck.fillTheDeck(new WayCard(2)); // ID 3
		Deck.fillTheDeck(new WayCard(7)); // ID 4
		Deck.fillTheDeck(new WayCard(6)); // ID 5
		Deck.fillTheDeck(new WayCard(5)); // ID 6
		Deck.fillTheDeck(new WayCard(3)); // ID 7
		p1.setHand();

		ArrayList<String> myHand = p1.getHandByTypes();

		assertEquals(myHand.get(0).toString().contains("TYPE"), true , "A kezben utkartyak vannak" );	
	}
	
	@Test
	void moreThanOnePlayer() {
		Game.clearPlayers();
		Game.setPlayerNum(4);
		Game.fillPlayers();
		Deck.cleanTheDeck();
		p1.cleanHand();
		
		for(int i = 0; i < 40; i++) {
			Deck.fillTheDeck(new WayCard());	
		}

		int kezdetiPakliSzam = Deck.getDeckSize();
		
		ArrayList<Player> plyr = Game.getPlayers();
				
		for (Player actualPlayer : plyr) {
			System.out.println(actualPlayer.getDwarfName());
			actualPlayer.setHand();
		}
		assertEquals(kezdetiPakliSzam - (4 * 6),
				     Deck.getDeckSize(),
				     "Negy jatekos lapokat huz a paklibol.");
	}
}
