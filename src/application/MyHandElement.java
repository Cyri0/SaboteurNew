package application;

import javafx.scene.control.Button;
import service_layer_cards.Card;
import service_layer_cards.CardType;
import service_layer_cards.WayCard;

public class MyHandElement {

	private Button b;
	private Card cd;
	
	public MyHandElement(Button b, int num) {
		super();
		this.b = b;
		
		if(num < ActualPlayer.get().getHand().size()) {

			this.cd = ActualPlayer.get().getHand().get(num);
			setButton();
			
			
			if(cd.getCardType() == CardType.WAYCARD)
			{
				WayCard wc = (WayCard) cd;
				ImageSetter.setImageInHand(b, wc.getWayCardType().toString());
			}
			else {
				ImageSetter.setImageInHand(b, cd.getCardType().toString());
			}
		}
		else
			{
			 b.setDisable(true);
			 b.setVisible(false);
			 }

	}
	
	public static boolean clicked;
	
	private void setButton() {
		clicked = true;
		
		b.setMinSize(240, 160);
		
		b.setOnAction((event) -> {
			if(clicked)
				MyHandElements.setAllDisableExcept(this);
			else
				MyHandElements.setAllEnable();
			
			clicked = !clicked;
			
			if(cd.getCardType() == CardType.WAYCARD)
				{
				WayCard wc = (WayCard) cd;
				SelectedWayCard.set(wc);
				}
			else {
				if(cd.getCardType() == CardType.MAP)
					{
					VisualMap.useMap();
					b.setDisable(true);
					}
			}
		});
	}
	
	public Button getButton() {
		return b;
	}
}
