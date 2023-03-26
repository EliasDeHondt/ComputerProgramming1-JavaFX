import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class MainVraag11 extends Application {
    @Override
    public void start(Stage primaryStage) {
        MyView view = new MyView();
        Scene scene = new Scene(view, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Vraag 11");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class MyView extends GridPane {
    private ComboBox<String> landenCombo;

    public MyView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.landenCombo = new ComboBox<>();
        this.landenCombo.getItems().addAll("Belgis", "Nederland", "Luxemburg");
        this.landenCombo.getSelectionModel().selectFirst();
    }

    private void layoutNodes() {
        this.add(this.landenCombo, 0, 0);
    }
}