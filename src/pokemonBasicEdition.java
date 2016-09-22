import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.Scanner;


public class pokemonBasicEdition extends Application {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Application.launch(args);

	}
	public void start(Stage primaryStage){
		Pane pane = new Pane();
		
		Rectangle textBox = new Rectangle(25, 300, 550, 75);
		textBox.setStroke(Color.BLUE);
		textBox.setFill(Color.GHOSTWHITE);
		textBox.setArcHeight(10);
		textBox.setArcWidth(10);
		
		Text intro1 = new Text(30, 335, "Welcome to the world of pokemon! A world where your wildest dreams can come true! But only if you choose to let them! Let us begin. What is your name?");
		intro1.setWrappingWidth(540);
		intro1.setTextAlignment(TextAlignment.CENTER);
		
		TextField playerName = new TextField();
		playerName.setAlignment(Pos.BOTTOM_LEFT);
		
		Button submit = new Button("Submit");
		
		BorderPane paneForPlayerName = new BorderPane();
		paneForPlayerName.setPadding(new Insets(130, 200, 150, 150));
		paneForPlayerName.setLeft(new Label("Enter Your Name: "));
		paneForPlayerName.setCenter(playerName);
		paneForPlayerName.setBottom(submit);
		
		
		

		pane.getChildren().addAll(textBox, intro1, paneForPlayerName);
		Scene scene = new Scene(pane, 600,400);
		primaryStage.setTitle("Pokemon Basic");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
