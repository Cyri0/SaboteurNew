package service_layer_physics;

import database_layer_highscore.MinerDatabase;
import service_layer_players.DwarfNames;
import service_layer_players.Goldminer;
import service_layer_players.Player;
import service_layer_players.Saboteur;

import java.util.ArrayList;
import java.util.Random;

public class Game {

	private static int playerNum = 0;
	private static int maxCardsInHand = 0;
	private static ArrayList<Player> players = new ArrayList<Player>();
	
/**
 * Ez a metodus megkap ket integer parametert, ami alapjan eldonti hogy hogy lesz osszeallitva a csapat.
 * A jatek izgalom faktorahoz tartozik, hogy nem tudjuk pontosan hany saboteur van.
 * @param saboteurs Max saboteur-ok szama.
 * @param goldminers Max goldminer-ek szama.
 */
	private static void setTheProportion(int saboteurs, int goldminers) {
		
		ArrayList<Player> fictionalPlayers = new ArrayList<Player>();
		
		for(int i = 0; i < saboteurs; i++) {
			Saboteur s = new Saboteur();
			s.setDwarfName(DwarfNames.getRandNameFromList());
			fictionalPlayers.add(s);
		}
		
		for(int i = 0; i < goldminers; i++) {
			Goldminer s = new Goldminer();
			s.setDwarfName(DwarfNames.getRandNameFromList());
			fictionalPlayers.add(s);
		}

		Random rnd = new Random();

		for(int i = 0; i < playerNum; i++) {
			int choosenNum = rnd.nextInt(fictionalPlayers.size());
			Player plyr = fictionalPlayers.get(choosenNum);
			players.add(plyr);
			
			fictionalPlayers.remove(plyr);
		}
	}
	
/**
 * Ezzel a metodussal kerhetjuk le a jatekosok tipusat.
 */
	public static void printPlayersType() {
		int count = 0;
		for (Player player : players) {
			count++;
			System.out.println("Jatekos_" + count + ": " + player.getType());
		}
	}
	
/**
 * Ez a metodus feltolti a players listat, ugyelve a jatekos-tipusok aranyara.
 */
	public static void fillPlayers() {
	
		switch (playerNum) {
		case 3:
				setTheProportion(1, 3);
			break;
		case 4:
				setTheProportion(1, 4);
			break;
		case 5:
				setTheProportion(2, 4);
			break;
		case 6:
				setTheProportion(2, 5);
			break;
		case 7:
				setTheProportion(3, 5);
			break;
		case 8:
				setTheProportion(3, 6);
			break;
		case 9:
				setTheProportion(3, 7);
			break;
		case 10:
				setTheProportion(4, 7);
			break;
		}
		
		MinerDatabase.initHightscore();
	}
		
/**
 * A metodus kitorli a jatekosokat.
 */
	public static void clearPlayers() {
		players = new ArrayList<Player>();
	}
	
/**
 * Visszaadja a jatekosok szamat.
 * @return Jatekosok szamat adja vissza.
 */
	public static int getPlayerNum () {
		return playerNum;
	}

/**
 * Visszaad egy listat, ami a jatekosokat tartalmazza.
 * @return Visszaadott ArrayList
 */
	public static ArrayList<Player> getPlayers(){
		return players;
	}
	
/**
 * Ezzel a metodussal lehet beallitani hany jatekos jatszik.
 * Automatikusan meghivja a setCardsInHand() metodust, amely beallitja hany lap lehet a kezunkben.
 * @param num A jatekosok szamat adja meg.
 */
	public static void setPlayerNum (int num) {
		playerNum = num;
		setCardsInHand();
	}
	
/*
 * Ez a metodus visszaadja a kezben tarthato kartyak maximalis szamat.
 * Ha a pakliban van meg lap, akkor kotelezo hogy a kezben maximalis szamu lap legyen.	
 */
	public static int getMaxCardsInHand() {
		return maxCardsInHand;
	}

/**
 * Beallitja a kezben tarthato lapok szamat a jatekosok szama alapjan.
 */
	private static void setCardsInHand() {

		switch (playerNum) {
		case 3:
		case 4:
		case 5:
			maxCardsInHand = 6;
			break;
		case 6:
		case 7:
			maxCardsInHand = 5;
			break;
		case 8:
		case 9:
		case 10:
			maxCardsInHand = 4;
			break;
		default: {maxCardsInHand = 0;}
			break;
		}
	}
	
}