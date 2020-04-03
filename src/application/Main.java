package application;
	
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import marine.chess.models.ChessBoard;
import marine.chess.models.ChessGame;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("/marine/chess/views/ViewChessGame.fxml"));
		
			Scene scene = new Scene(fxmlLoader.load());

            primaryStage.setTitle("My Chess Game");
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
			primaryStage.show();
			
//			ChessGame game = new ChessGame();
//			String message;
//			message = game.play("black", 1, 1, 3, 1);
//			if (message != "") {
//				System.out.println(message);
//			}
//			message = game.play("black", 3, 1, 6, 1);
//			if (message != "") {
//				System.out.println(message);
//			}
//			game.cancel();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
