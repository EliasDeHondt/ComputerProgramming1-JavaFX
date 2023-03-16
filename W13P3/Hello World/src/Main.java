import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * @author Elias De Hondt
 * 5/02/2023
 */

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label lblHello = new Label("Hello World!");

        BorderPane root = new BorderPane(lblHello);

        Scene scene1 = new Scene(root);

        // Verander de cursor van de Scene naar een kruisje.
        scene1.setCursor(Cursor.CROSSHAIR);

        // Maak een tweede Scene aan met als rootnode:
        Scene scene2 = new Scene(new Group());

        // Kan je de grootte van een Scene aanpassen?
        // Nee dat kan niet.

        primaryStage.setScene(scene1);

        // Maak de stage 500x600 pixels groot.
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(600);

        // Zorg dat het scherm niet aangepast kan worden in grootte.
        primaryStage.setResizable(false);

        // Geef een titel aan de stage.
        primaryStage.setTitle("Hello World!");

        // Kan je de maximale breedte instellen?
        primaryStage.setMaxHeight(800);

        // Kan je een tweede Stage aanmaken en tonen?
        Stage tweedeStage = new Stage();

        // Plaatst deze scene op de stage.
        tweedeStage.setScene(scene2);

        // Show tweedeStage
        tweedeStage.show();

        // Show primaryStage
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
