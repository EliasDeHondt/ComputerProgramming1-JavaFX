package be.kdg;

import be.kdg.transition.view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Geen MVP; enkel een View-klasse waarin Transitions gebruikt worden om een vierkant te laten bewegen.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        final View view = new View();
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Transition");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
