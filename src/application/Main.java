package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;
import java.io.File;
import java.net.URL;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = new File("src/application/View.fxml").toURI().toURL();
			Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root);

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}