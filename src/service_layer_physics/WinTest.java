package service_layer_physics;

import database_layer_highscore.MinerDatabase;
import service_layer_cards.CardType;
import service_layer_cards.GoldCard;
import service_layer_players.Goldminer;
import service_layer_players.Player;
import service_layer_players.Saboteur;

public class WinTest {

	public static int win() {
		
		GoldCard gc = GoldCard.getSingleton();
		
		int x;
		int y = 9;
		
		if(Table.getTableElement(0, y).getCardType() == CardType.GOLD) x = 0;
		else if(Table.getTableElement(2, y).getCardType() == CardType.GOLD) x = 2;
		else x = 4;
		if(Table.checkConnection(gc, x, y))
			{return 1;}
		
		int stone1, stone2;
		
		if(x == 0) {stone1 = 2; stone2 = 4;}
		if(x == 2) {stone1 = 0; stone2 = 4;}
		else {stone1 = 0; stone2 = 2;}
		
		if(Table.checkConnection(Table.getTableElement(stone1, y), stone1, y) ||
		   Table.checkConnection(Table.getTableElement(stone2, y), stone2, y)
				)
			{return 2;}
		
		else return 0;
	}
	
	public static void givePoints() {
		Player p;
		
		if(WinTest.win() == 1) {
			p = new Goldminer();
		}
		else {
			p = new Saboteur();
		}
		
		for(Player ply:Game.getPlayers()) {
			if(ply.getType() == p.getType()) {
				ply.addToTheScore();
				//System.out.println(ply.getDwarfName() + " kap egy pontot! Pontjai: " + ply.getTheScore());
			}
		}
		MinerDatabase.setTheHighscore();
	}
}