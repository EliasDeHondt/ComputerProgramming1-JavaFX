import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author Elias De Hondt
 * @since 27/03/2023
 */

public class MyCircleApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Maak een Circle object
        Circle circle = new Circle(100, 100, 50);

        // Stel de kleur van de cirkel in op rood
        circle.setFill(Color.RED);

        // Maak een Pane object en voeg de cirkel toe
        Pane root = new Pane();
        root.getChildren().add(circle);

        // Maak een Scene object en voeg de Pane toe
        Scene scene = new Scene(root, 200, 200);

        // Stel de titel van het venster in en toon het
        primaryStage.setTitle("My Circle App");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/img.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
