package be.kdg.pong.view;

import be.kdg.pong.model.Ball;
import be.kdg.pong.model.Paddle;
import be.kdg.pong.model.Pong;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.awt.*;

public class PongPresenter {
    private final Pong model;
    private final PongView view;
    private Timeline gameLoop;

    public PongPresenter(Pong model, PongView view) {
        this.model = model;
        this.view = view;
        addEventhandlers();
        setUpGameLoop();
        updateView();
    }

    private void setUpGameLoop() {
        this.gameLoop = new Timeline(new KeyFrame(Duration.millis(15), actionEvent -> {
            this.model.update();
            updateView();
        }));
        this.gameLoop.setCycleCount(Animation.INDEFINITE);
    }
    private void addEventhandlers() {
        this.view.getCanvas().setOnMouseMoved(mouseEvent -> {
            this.model.getPaddle().setX((int) mouseEvent.getX());
            updateView();
        });
        this.view.getBtnStart().setOnAction(actionEvent -> {
            this.view.getBtnStart().setDisable(false);
            this.model.reset();
            this.gameLoop.play();
        });
    }

    private void updateView() {
        GraphicsContext gc = this.view.getCanvas().getGraphicsContext2D() ;
        // Canvas
        gc.setFill(Color.YELLOWGREEN);
        gc.fillRect(0,0, Pong.FIELD_WIDTH, Pong.FIELD_HEIGHT);
        // Ball
        Ball ball = this.model.getBall();
        gc.setFill(Color.RED);
        gc.fillOval(ball.getX(),ball.getY(),Ball.DEFAULT_RADIUS*2,Ball.DEFAULT_RADIUS*2);
        // Paddel
        Paddle paddle = this.model.getPaddle();
        gc.setFill(Color.BLACK);
        gc.fillRect(paddle.getX(),paddle.getY(),paddle.getW(),paddle.getH());
        // C
        gc.setFont(new Font(36));
        gc.fillText("Score " + this.model.getScore(), 20,50);
        // Lost
        if (this.model.isLost()) {
            this.gameLoop.stop();
            showAnimation();
        }
    }

    private void showAnimation() {
        Label label = this.view.getLblYouLost();
        label.setVisible(true);
        this.view.getBtnStart().setDisable(true);
        label.setText("You lost! Score" + this.model.getScore());
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), label);
        rotateTransition.setToAngle(720);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(3), label);
        scaleTransition.setToX(4);
        scaleTransition.setToY(4);

        ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, scaleTransition);

        parallelTransition.play();
    }
}
