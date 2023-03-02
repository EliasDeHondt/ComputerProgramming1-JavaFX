package be.kdg.schermen.view.game;

import be.kdg.schermen.model.SimpleModel;
import be.kdg.schermen.view.about.AboutPresenter;
import be.kdg.schermen.view.about.AboutView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GamePresenter {
    private SimpleModel model;
    private GameView view;

    public GamePresenter(SimpleModel model, GameView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getMiAbout().setOnAction(event -> {
            AboutView aboutView = new AboutView();
            AboutPresenter aboutPresenter = new AboutPresenter(model, aboutView);
            Stage aboutStage = new Stage();
            aboutStage.initOwner(view.getScene().getWindow());
            aboutStage.initModality(Modality.APPLICATION_MODAL); // Gebonden venster!
            aboutStage.setScene(new Scene(aboutView)); //Tonen in een NIEUWE scene
            aboutStage.setX(view.getScene().getWindow().getX() + 100);
            aboutStage.setY(view.getScene().getWindow().getY() + 150);
            aboutStage.showAndWait();
        });
    }

    private void updateView() {
        //Hier niet van toepassing
    }
}
