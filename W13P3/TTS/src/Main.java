import be.kdg.dictee.View.DicteeView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Van Elias De Hondt
 * 6/02/2023
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // Maak new View (DicteeView)
        DicteeView dicteeView = new DicteeView();
        Scene scene = new Scene(dicteeView);

        stage.setScene(scene);
        stage.setWidth(250);
        stage.setHeight(400);
        stage.setTitle("Dictee");
        stage.show();



    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
