package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import service_layer_cards.CardType;
import service_layer_cards.WayCard;
import service_layer_physics.Table;

public class VisualTableElement {
	private WayCard cd;
	private int x;
	private int y;
	private Button b;
	
	public VisualTableElement(int x, int y, Button b) {
		super();	
		this.x = x;
		this.y = y;
		this.b = b;
		
		setCard();
		setButton();
	}
	
	private void setButton() {
		b.setMinSize(120, 80);
				
		ImageSetter.setImageOnTable(b, cd.getCardType().toString());	
		
		b.setOnAction((event) -> {
				
			if(Table.checkConnection(SelectedWayCard.get(), x, y) &&
			   VisualTable.getElementByCoordinates(x, y).getCd().getCardType() != CardType.WAYCARD &&
			   Table.lineIsClear(y)
					) {
				
				Table.setTableElement(SelectedWayCard.get(), x, y);
				setCard();
				WayCard wc = (WayCard) cd;
				ImageSetter.setImageOnTable(b, wc.getWayCardType().toString());
				VisualTable.setAllDisable();
				ActualPlayer.get().useOneCardFromHand(cd);
				ActualPlayer.get().pickACard();				
				ImageSetter.setWinTable();
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("You can't use this card here!");
				alert.initModality(Modality.NONE);				
				alert.showAndWait();
			}
		});
	}
	
	private void setCard() {
		cd = Table.getTableElement(x, y);
	}

	public WayCard getCd() {
		return cd;
	}

	public int getX() {
		return x;
	}

	public  int getY() {
		return y;
	}

	public Button getButton() {
		return b;
	}
}
