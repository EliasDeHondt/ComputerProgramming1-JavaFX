import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class MainVraag3 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Vraag3 view = new Vraag3();
        primaryStage.setTitle("RadioButtons");
        primaryStage.setScene(new Scene(view));
        primaryStage.setHeight(100);
        primaryStage.setWidth(300);
        primaryStage.show();

        // Get the selected radio button
        RadioButton selectedButton = view.getSelectedButton();
        System.out.println("Selected button: " + selectedButton.getText());

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
