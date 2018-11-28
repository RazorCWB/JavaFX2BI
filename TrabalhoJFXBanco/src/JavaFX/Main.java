package JavaFX;
import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws IOException {

		Pane root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
		
		Scene scene = new Scene(root, 703, 556);
		primaryStage.setScene(scene);
		primaryStage.show();
		setPrimaryStage(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		Main.primaryStage = primaryStage;
	}

}
