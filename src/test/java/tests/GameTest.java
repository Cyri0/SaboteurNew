package test.java.tests;

import org.junit.jupiter.api.Test;
import service_layer_physics.Game;
import service_layer_players.Player;
import service_layer_players.Saboteur;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GameTest {

	@Test
	void testPlayerNumbers2() {
		int handNum = 0;
		Game.setPlayerNum(2);
		String problem = "Tul Keves Kartya";
		assertEquals(Game.getMaxCardsInHand(), handNum, problem);
	}

	@Test
	void testPlayerNumbers3() {
		int handNum = 6;
		Game.setPlayerNum(3);
		String problem = "3-ra teszteles";
		assertEquals(Game.getMaxCardsInHand(), handNum, problem);
	}

	@Test
	void testPlayerNumbers5() {
		int handNum = 6;
		Game.setPlayerNum(5);
		String problem = "5-re teszteles";
		assertEquals(Game.getMaxCardsInHand(), handNum, problem);
	}

	@Test
	void testPlayerNumbers6() {
		int handNum = 5;
		Game.setPlayerNum(6);
		String problem = "6-ra teszteles";
		assertEquals(Game.getMaxCardsInHand(), handNum, problem);
	}
	@Test
	void testPlayerNumbers7() {
		int handNum = 5;
		Game.setPlayerNum(7);
		String problem = "7-re teszteles";
		assertEquals(Game.getMaxCardsInHand(), handNum, problem);
	}
	@Test
	void testPlayerNumbers8() {
		int handNum = 4;
		Game.setPlayerNum(8);
		String problem = "8-ra teszteles";
		assertEquals(Game.getMaxCardsInHand(), handNum, problem);
	}
	@Test
	void testPlayerNumbers10() {
		int handNum = 4;
		Game.setPlayerNum(10);
		String problem = "10-re teszteles";
		assertEquals(Game.getMaxCardsInHand(), handNum, problem);
	}
	@Test
	void testPlayerNumbers11() {
		int handNum = 0;
		Game.setPlayerNum(11);
		String problem = "11-re teszteles";
		assertEquals(Game.getMaxCardsInHand(), handNum, problem);
	}
	
	@Test
	void testPlayerProportion10() {
		int portion = 10;
		Game.clearPlayers();
		Game.setPlayerNum(portion);
		Game.fillPlayers();
		Game.printPlayersType();
		assertEquals(portionTest(portion, countSaboteurs()), true, "Nincs elég saboteur (10 játékosnál)!");
	}

	int countSaboteurs(){
		int saboteur = 0;
		ArrayList<Player> players = Game.getPlayers();
		for(Player p : players){
			if(p.getClass() == new Saboteur().getClass()){
				saboteur++;
			}
		}
		return saboteur;
	}

	boolean portionTest(int portion, int saboteur){
		System.out.println("Portion: "+ portion);
		if(portion == 3 || portion == 4){
			if(saboteur == 1 || saboteur == 0){
				return true;
			}
		} else
		if(portion == 5 || portion == 6){
			if(saboteur == 1 || saboteur == 2){
				return true;
			}
		} else
		if(portion >= 7 && portion <= 9){
			if(saboteur == 2 || saboteur == 3){
				return true;
			}
		} else if(portion == 10){
			if(saboteur == 3 || saboteur == 4){
				return true;
			}
		}
		return false;
	}

}