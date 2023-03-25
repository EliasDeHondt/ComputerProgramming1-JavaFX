import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class MainVraag4 extends Application {
    @Override
    public void start(Stage primaryStage) {
        MyView view = new MyView();
        new Presenter(view);

        primaryStage.setTitle("Vraag 4");
        primaryStage.setScene(new Scene(view, 300, 100));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class MyView extends BorderPane {
    private final Button myButton;

    public MyView() {
        myButton = new Button("Click me!");
        setCenter(myButton);
    }

    public Button getMyButton() {
        return myButton;
    }
}

class Presenter {
    private final MyView view;

    public Presenter(MyView view) {
        this.view = view;
        handleEvents();
    }

    private void handleEvents() {
        view.getMyButton().setOnMouseClicked(event -> {
            Button button = view.getMyButton();
            button.setText("What the...!");
            button.setStyle("-fx-text-fill: crimson");
            button.setMinWidth(200);
        });
    }
}
