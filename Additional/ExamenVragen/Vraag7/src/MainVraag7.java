import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.font.TextHitInfo;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class MainVraag7 extends Application {
    @Override
    public void start(Stage primaryStage) {
        MyView view = new MyView();
        new Presenter(view);
        primaryStage.setTitle("Vraag 7");
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class MyView extends VBox {
    private Button BtnNextScreen;

    public MyView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.BtnNextScreen = new Button("Next Screen");
    }

    private void layoutNodes() {
        this.getChildren().add(this.BtnNextScreen);
        this.setPadding(new Insets(20));
    }

    public Button getBtnNextScreen() {
        return this.BtnNextScreen;
    }
}
class GameView extends BorderPane {
    private Label label;
    public GameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {
        this.label = new Label("Game View");
    }

    private void layoutNodes() {
        this.setPadding(new Insets(20));
        this.setCenter(this.label);
    }
}

class Presenter {
    private final MyView view;

    public Presenter(MyView view) {
        this.view = view;
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        this.view.getBtnNextScreen().setOnAction(event -> {
            GameView gameView = new GameView();
            new GamePresenter(gameView);
            this.view.getScene().setRoot(gameView);
            gameView.getScene().getWindow().sizeToScene();
        });
    }
}
class GamePresenter {
    private final GameView view;
    public GamePresenter(GameView view) {
        this.view = view;
    }

}