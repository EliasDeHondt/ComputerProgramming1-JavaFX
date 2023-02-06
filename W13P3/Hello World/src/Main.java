import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * Van Elias De Hondt
 * 5/02/2023
 */

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label lblHello = new Label("Hello World!");
        BorderPane root = new BorderPane(lblHello);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
