package be.kdg.schermen.view.start;

import be.kdg.schermen.model.SimpleModel;
import be.kdg.schermen.view.game.GamePresenter;
import be.kdg.schermen.view.game.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

public class StartPresenter {
    private SimpleModel model;
    private StartView view;

    public StartPresenter(SimpleModel model, StartView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getBtnNextScreen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameView gameView = new GameView();
                GamePresenter gamePresenter = new GamePresenter(model, gameView);
                view.getScene().setRoot(gameView); //DEZELFDE scene gebruiken!
                gameView.getScene().getWindow().sizeToScene(); //Om het venster te laten aanpassen aan nieuwe grootte
            }
        });
    }

    public void voegWindowEventToe() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Hierdoor stopt het spel!");
                alert.setContentText("Ben je zeker?");
                alert.setTitle("Opgelet!");
                alert.getButtonTypes().clear();
                ButtonType neen = new ButtonType("Neen");
                ButtonType ja = new ButtonType("Ja");
                alert.getButtonTypes().addAll(neen, ja);
                alert.showAndWait();
                if (alert.getResult() == null || alert.getResult().equals(neen)) {
                    event.consume();
                }
            }
        });
    }

    private void updateView() {
        //Hier niet van toepassing
    }
}
