package application;

import javafx.scene.control.Button;
import service_layer_physics.WinTest;

public abstract class ImageSetter {

	private static String num1 = "img/1";
	private static String num2 = "img/2";
	private static String num3 = "img/3";
	private static String num4 = "img/4";
	private static String num5 = "img/5";
	private static String num6 = "img/6";
	private static String num7 = "img/7";
	private static String secret = "img/secret";
	private static String map = "img/map";
	private static String stone = "img/stone";
	private static String gold = "img/gold";
	private static String start = "img/start";
	private static String empty = "img/empty";
	
	public static void setImageInHand(Button b1, String typeStr) {
        b1.setStyle("-fx-background-image: url('" + getChoosen(typeStr) + ".jpg"+"')");
	}
	
	public static void setImageInHand(Button b1, String typeStr, boolean flipped) {
		if(flipped)
			b1.setStyle("-fx-background-image: url('" + getChoosen(typeStr) + "_flipped.jpg"+"')");
		b1.setStyle("-fx-background-image: url('" + getChoosen(typeStr) + ".jpg"+"')");
	}
	
	private static String getChoosen(String str) {
		
		String choosen = "";
		if(str.contains("EMPTY")) {choosen = empty; }
		if(str.contains("MAP")) {choosen = map; }		
		if(WinTest.win() == 1 || WinTest.win() == 2) {
			if(str.contains("STONE")) { choosen = stone; }
			if(str.contains("GOLD")) { choosen = gold; }
		}
		else {
			if(str.contains("STONE")) { choosen = secret; }
			if(str.contains("GOLD")) { choosen = secret; }
		}
		
		if(str.contains("START")) { choosen = start;}
		if(str.contains("1")) { choosen = num1; }
		if(str.contains("2")) { choosen = num2; }
		if(str.contains("3")) { choosen = num3; }
		if(str.contains("4")) { choosen = num4; }
		if(str.contains("5")) { choosen = num5; }
		if(str.contains("6")) { choosen = num6; }
		if(str.contains("7")) { choosen = num7; }
		
		return choosen;
	}

	public static void setWinTable() {
		
		VisualTable.getElementByCoordinates(0, 9).getButton().
		setStyle("-fx-background-image: url('" + getChoosen(VisualTable.getElementByCoordinates(0, 9).getCd().getCardType().toString()) + "_small.jpg" + "')");
		
		VisualTable.getElementByCoordinates(2, 9).getButton().setStyle("-fx-background-image: url('" + 
		getChoosen(VisualTable.getElementByCoordinates(2, 9).getCd().getCardType().toString()) + "_small.jpg" + "')");

		VisualTable.getElementByCoordinates(4, 9).getButton().setStyle("-fx-background-image: url('" + 
		getChoosen(VisualTable.getElementByCoordinates(4, 9).getCd().getCardType().toString()) + "_small.jpg" + "')");
		
	}
	

	public static void setImageOnTable(Button b1, String typeStr) {
        b1.setStyle("-fx-background-image: url('" + getChoosen(typeStr) + "_small.jpg" + "')");

	}
	
	public static void setImageOnTable(Button b1, String typeStr, boolean flipped) {
		if(flipped)
			b1.setStyle("-fx-background-image: url('" + getChoosen(typeStr) + "_small_flipped.jpg" + "')");
		b1.setStyle("-fx-background-image: url('" + getChoosen(typeStr) + "_small.jpg" + "')");

	}
}