package application;

public class VisualTable {

	
	private static VisualTableElement[][] visualTable = new VisualTableElement[5][10];
	
	public static void addNewElement(VisualTableElement vte) {
		visualTable[vte.getX()][vte.getY()] = vte;
	}
	
	public static VisualTableElement getElementByCoordinates(int x, int y) {
		VisualTableElement vte = null;
		if(x <= 4 && x >= 0 && y <= 9 && y >= 0)
			vte = visualTable[x][y];
		return vte;
	}
	
	public static void setAllDisable() {
		
		for (VisualTableElement[] vTes : visualTable) {
			for (VisualTableElement vTe : vTes) {
				vTe.getButton().setDisable(true);
			}
		}
		
	}
	
	public static void setAllEnable() {
		for (VisualTableElement[] vTes : visualTable) {
			for (VisualTableElement vTe : vTes) {
				vTe.getButton().setDisable(false);
			}
		}
	}
	
}
