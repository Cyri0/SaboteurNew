package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import service_layer_physics.Table;

import java.util.Optional;

public class VisualMap {

	public static void useMap() {
		
		Alert resultCard = new Alert(AlertType.INFORMATION);
		resultCard.setTitle("Result");	
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Map");
		alert.setHeaderText("Choose goalcard!");

		ButtonType buttonTypeOne = new ButtonType("Left");
		ButtonType buttonTypeTwo = new ButtonType("Middle");
		ButtonType buttonTypeThree = new ButtonType("Right");
		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
			VisualTable.setAllDisable();
			resultCard.setHeaderText("The left card is " + Table.getTableElement(0,9).getCardType().toString());
			resultCard.showAndWait();
		} else if (result.get() == buttonTypeTwo) {
			VisualTable.setAllDisable();
			resultCard.setHeaderText("The middle card is " + Table.getTableElement(2,9).getCardType().toString());
			resultCard.showAndWait();
		} else if (result.get() == buttonTypeThree) {
			VisualTable.setAllDisable();
			resultCard.setHeaderText("The right card is " + Table.getTableElement(4,9).getCardType().toString());
			resultCard.showAndWait();
		} else {
			MyHandElements.setAllEnable();
		}	
	}
	
}
