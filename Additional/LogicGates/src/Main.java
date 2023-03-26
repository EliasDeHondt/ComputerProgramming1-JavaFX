import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import logicGates.model.LogicGates;
import logicGates.view.welcome.WelcomePresenter;
import logicGates.view.welcome.WelcomeView;

/**
 * The main for the game.
 *
 * @author Elias De Hondt
 * @since 26/03/2023
 */
public class Main extends Application {
    // Methods
    public static void main(String[] args) { // Main
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) { // Start
        LogicGates model = new LogicGates();
        WelcomeView view = new WelcomeView();
        new WelcomePresenter(model, view);
        Scene scene = new Scene(view);
        scene.getStylesheets().add("/style.css");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/logo.png"));
        primaryStage.setTitle("Welcome");
        primaryStage.show();
    }
}