package service_layer_physics;

import java.util.Random;

import service_layer_cards.CardType;
import service_layer_cards.GoldCard;
import service_layer_cards.Orientation;
import service_layer_cards.StartCard;
import service_layer_cards.StoneCard;
import service_layer_cards.WayCard;

public class Table {

	private static WayCard[][] cardTable = new WayCard[5][10];

	/**
	 * Letrehozza az asztalt a jatek elejen.
	 */
	public static void initTable() {
		Random rnd = new Random();
		int random = rnd.nextInt(3);
				
		for(int oszlop = 0; oszlop < 5; oszlop++) {
			for(int sor = 0; sor < 10; sor++) {
				
				WayCard cd = typeSetter(sor, oszlop, random);
				//cd.useTheCard(sor, oszlop);
				cardTable[oszlop][sor] = cd;	
			}
		}
	}
		
	/**
	 * Beallitja hogy hol van arany, es hol van ures kartya.
	 * @param sor melyik sorba
	 * @param oszlop melyik oszlopba
	 * @param random megadja hogy hol az arany
	 * @return kartya peldany
	 */
	private static WayCard typeSetter(int sor, int oszlop, int random) {
		WayCard cd;
		
		if(sor == 1 && oszlop == 2) {
			cd = new StartCard();
			return cd;
		}
		else if(sor == 9) {
				if(oszlop == random*2){
					cd = new GoldCard();
					return cd;
					}
				else if(oszlop == 0 || oszlop == 2 || oszlop == 4){
					cd = new StoneCard();
					return cd;
					}
			}
		cd = new WayCard();
		return cd;
	}
	
	
	
	public static WayCard[][] getCardTable() {
		return cardTable;
	}

	public static void setCardTable(WayCard[][] cardTable) {
		Table.cardTable = cardTable;
	}

	public static WayCard getTableElement(int x, int y) {
		WayCard cd = cardTable[x][y];
		return cd;
	}
	
	public static void setTableElement(WayCard wc, int x, int y) {
		cardTable[x][y] = wc;
	}
	
	public static boolean checkConnection(WayCard wc, int x, int y) {		
		WayCard wc1 = new WayCard();
		WayCard wc2 = new WayCard();
		WayCard wc3 = new WayCard();
		WayCard wc4 = new WayCard();

		if(y > 0) wc1 = cardTable[x][y-1];
		if(y < 9) wc2 = cardTable[x][y+1];
		if(x < 4) wc3 = cardTable[x+1][y];
		if(x > 0) wc4 = cardTable[x-1][y];
		
		
		if(wc1.canConnectTo(wc, Orientation.DOWN) ||
		   wc2.canConnectTo(wc, Orientation.UP) ||
		   wc3.canConnectTo(wc, Orientation.LEFT) ||
		   wc4.canConnectTo(wc, Orientation.RIGHT))
			return true;

		return false;
	}
	
	
	public static boolean lineIsClear(int y) {
		
		if(y == 0 || y == 1) return true;
		
		int emptyk = 0;
		
		for(int i = 0; i < 5; i++) {
			if(cardTable[i][y-1].getCardType()==CardType.EMPTY) {
				emptyk++;
			}
		}
		if(emptyk == 5) return false;			
		return true;
	}
	
	
	/**
	 * Kiirja az asztal tartalmat.
	 */
	public static void printTableTypes() {
		for(int sor = 0; sor < 10; sor++) {
			System.out.println();
		for(int oszlop = 0; oszlop < 5; oszlop++) {
			System.out.print("[" + cardTable[oszlop][sor].getCardType().toString() + "]");
			System.out.print(" ");
			}
		System.out.println();
		}
	}
	
	public static void printTableCoordinates() {
		for(int sor = 0; sor < 10; sor++) {
			System.out.println();
		for(int oszlop = 0; oszlop < 5; oszlop++) {
			System.out.print(" ");
			}
		System.out.println();
		}
	}
}