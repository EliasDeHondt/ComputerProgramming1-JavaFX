package be.kdg.pong.view;

import be.kdg.pong.model.Ball;
import be.kdg.pong.model.Paddle;
import be.kdg.pong.model.Pong;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class PongPresenter {
    private final Pong model;
    private final PongView view;

    public PongPresenter(Pong model, PongView view) {
        this.model = model;
        this.view = view;
        addEventhandlers();
        setUpGameLoop();
        updateView();
    }

    private void setUpGameLoop() {
        //TODO: gebruik een Timeline voor de gameloop

    }

    private void addEventhandlers() {
        //TODO: Voeg event toe voor beweging paddle

        //TODO: voeg ActionEvent toe aan button

    }

    private void updateView() {
        //TODO: bal tekenen
        //TODO: paddle tekenen
        //TODO: Score tekenen

    }
}
