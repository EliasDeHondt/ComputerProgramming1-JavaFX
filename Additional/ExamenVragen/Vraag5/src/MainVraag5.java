import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class MainVraag5 extends Application {
    @Override
    public void start(Stage primaryStage) {
        MyView view = new MyView();
        primaryStage.setTitle("Vraag 5");
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class MyView extends VBox {
    private final static String[] text = {"Koen", "Paula", "Evy", "Katrien"};
    private final Button[] buttons = new Button[text.length];

    public MyView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        for (int i = 0; i < text.length; i++) {
            this.buttons[i] = new Button(text[i]);
            this.getChildren().add(this.buttons[i]); // voeg knoppen toe aan View-object
        }
    }

    private void layoutNodes() {
        this.setPadding(new Insets(40));
        this.setSpacing(10); // voeg deze regel toe om ruimte tussen de knoppen in te stellen
        for (int i = 0; i < text.length; i++) {
            this.buttons[i].setAlignment(Pos.CENTER);
            this.buttons[i].setPrefWidth(80);
            this.buttons[i].setPrefHeight(40);
        }
    }
}
