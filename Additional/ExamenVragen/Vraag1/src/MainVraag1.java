import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class MainVraag1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Vraag1 view = new Vraag1();
        Scene scene = new Scene(view);
        primaryStage.setTitle("Graphics");
        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        primaryStage.show(); // Antwoord
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
