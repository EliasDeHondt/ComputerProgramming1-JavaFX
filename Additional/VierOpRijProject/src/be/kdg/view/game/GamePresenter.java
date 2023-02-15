package be.kdg.view.game;

import be.kdg.model.Schijf;
import be.kdg.model.SpelBord;
import be.kdg.model.VierOpRij;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GamePresenter {
    private VierOpRij model;
    private GameView view;

    public GamePresenter(VierOpRij model, GameView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        //TODO
    }

    private void updateView() {
        //TODO
    }
}
