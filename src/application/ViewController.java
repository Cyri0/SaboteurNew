package application;

import java.net.URL;
import java.util.ResourceBundle;

import database_layer_highscore.MinerDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import service_layer_physics.Deck;
import service_layer_physics.Game;
import service_layer_physics.Table;
import service_layer_physics.WinTest;
import service_layer_players.Player;

public class ViewController implements Initializable{

	@FXML
	private AnchorPane openPane;
	@FXML
	private AnchorPane gamePane;
	@FXML
	private AnchorPane bigBlack;
	@FXML
	private AnchorPane infoPane;
	@FXML
	private AnchorPane goldminerWinPane;
	@FXML
	private AnchorPane swinPane;
	@FXML
	private AnchorPane scorePane;
	@FXML
	private GridPane gameField;
	@FXML
	private GridPane myHand;
	@FXML
	private Label number;
	@FXML
	private Label score;
	@FXML
	private Label dwarfType;
	
	@FXML
	private Label cardsInDeck;
	
	@FXML
	private Label dwarfName;
	private int num = 3;
	
	@FXML
	private void minus(ActionEvent event) {
		if(num > 3)
		num--;
		number.setText(String.valueOf(num));
	}
	
	public int maxPlayer = 5;
	
	
	@FXML
	private void plus(ActionEvent event) {
		if(num < maxPlayer)
		num++;
		number.setText(String.valueOf(num));
	}

	private void switchTo(AnchorPane from, AnchorPane to) {
		from.setVisible(false);
		to.setVisible(true);
	}
	
	private int actualPlayerNum = 0;
	
	private void initGamePage() {
		ActualPlayer.set(Game.getPlayers().get(actualPlayerNum));
		VisualTable.setAllEnable();
		setPlayerDatas();
		setHandField();
		setCardsInDeck();
	}
	
	private void setCardsInDeck() {
		
		cardsInDeck.setText("Cards in deck: " + Deck.getDeckSize());
	}
	
	private void setPlayerDatas() {
		dwarfType.setText(ActualPlayer.get().getType());
		dwarfName.setText(ActualPlayer.get().getDwarfName());
	}
	private void setGameField() {
		Table.initTable();
		for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 10; j++) {
					Button fieldButton = new Button();									
					VisualTableElement actual = new VisualTableElement(i, j, fieldButton);
					VisualTable.addNewElement(actual);
					gameField.add(fieldButton, i, j);
				}}	
	}
	
	
	private void setHandField() {
		int num = 0;
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				MyHandElement myhand = new MyHandElement(new Button(), num);
				MyHandElements.addElement(myhand);
				myHand.add(myhand.getButton(), i, j);
				num++;
			}}
	}
	
	@FXML
	private void initPlayers(ActionEvent event) {		
		/**
		 * This button set the players number,
		 * set the players hand and
		 * initialize the first page,
		 * than switch to the bigBlack
		 */
		Game.clearPlayers();
		setGameField();
		Deck.cleanTheDeck();
		Deck.fillTheDeckWithBasic();
		Game.setPlayerNum(num);
		Game.fillPlayers();
		
		for (Player plyer : Game.getPlayers()) {
			plyer.setHand();
		}
		switchTo(openPane, bigBlack);	
	}
	
	@FXML
	private void infoButton(ActionEvent event) {
		switchTo(openPane, infoPane);
	}
	
	@FXML
	private void infoBack(ActionEvent event) {
		switchTo(infoPane, openPane);
	}
	
	@FXML
	private void newGame(ActionEvent event) {
		switchTo(scorePane, openPane);
	}
	
	@FXML
	private void switchToScore(ActionEvent event) {
		goldminerWinPane.setVisible(false);
		swinPane.setVisible(false);
		scorePane.setVisible(true);
	}
	
	private void scoreSetter() {
		
		score.setText(MinerDatabase.getTheHighScore());
		score.setMaxWidth(500);
		score.setMaxHeight(800);
		score.setWrapText(true);
		
	}
	
	@FXML
	private void nextPlayerButton(ActionEvent event) {
		if(actualPlayerNum < Game.getPlayerNum()-1)
			actualPlayerNum++;
		else actualPlayerNum = 0;
		
		if(WinTest.win() == 1 || WinTest.win() == 2) {
			WinTest.givePoints();
			scoreSetter();
			gameField.getChildren().clear();
			
			if(WinTest.win() == 1)
				switchTo(gamePane, goldminerWinPane);
			if(WinTest.win() == 2)
				switchTo(gamePane, swinPane);
			}
		else switchTo(gamePane, bigBlack);
	}
	
	@FXML
	private void showNext(ActionEvent event) {		
		initGamePage();
		switchTo(bigBlack, gamePane);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}