package be.kdg.transition.view;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class View extends Group {
    private Canvas canvas;
    private Rectangle movingRectangle;
    private Rectangle[] fourCorners;

    public View() {
        this.initialiseNodes();
        this.layoutNodes();
        this.animate();
    }

    private void initialiseNodes() {
        this.canvas = new Canvas(600, 600);
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(Color.CORNFLOWERBLUE);
        gc.fillRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());

        this.movingRectangle = new Rectangle(100, 100, 100, 100);
        this.movingRectangle.setArcHeight(15);
        this.movingRectangle.setArcWidth(15);
        this.movingRectangle.setFill(Color.BLUEVIOLET);

        this.fourCorners = new Rectangle[4];
        this.fourCorners[0] = new Rectangle(100, 100, 100, 100);
        this.fourCorners[1] = new Rectangle(400, 100, 100, 100);
        this.fourCorners[2] = new Rectangle(400, 400, 100, 100);
        this.fourCorners[3] = new Rectangle(100, 400, 100, 100);

        for (Rectangle r : this.fourCorners) {
            r.setFill(Color.DARKGRAY);
        }
    }

    private void layoutNodes() {
        this.getChildren().add(this.canvas);
        this.getChildren().addAll(this.fourCorners);
        this.getChildren().add(this.movingRectangle);
    }

    private void animate() {
//        TranslateTransition transition1 = new TranslateTransition();
//        transition1.setNode(this.movingRectangle);
//        transition1.setByX(300);
//        transition1.setDuration(Duration.seconds(1));
//        transition1.setCycleCount(Animation.INDEFINITE);
//        transition1.setInterpolator(Interpolator.EASE_BOTH);
//        transition1.play();
//
//        RotateTransition transition2 = new RotateTransition();
//        transition2.setNode(this.movingRectangle);
//        transition2.setDuration(Duration.millis(300));
//        transition2.setByAngle(90);
//        transition2.setCycleCount(Animation.INDEFINITE);
//        transition2.play();
//
//        SequentialTransition sequentialTransition = new SequentialTransition();
//        sequentialTransition.setCycleCount(Animation.INDEFINITE);
//        sequentialTransition.getChildren().addAll(transition2,transition1);
//        sequentialTransition.play();

        TranslateTransition[] transitions1 = new TranslateTransition[4];

        for (int i = 0; i < 4; i++) {
            transitions1[i] = new TranslateTransition();
            transitions1[i].setNode(this.movingRectangle);
            transitions1[i].setDuration(Duration.seconds(1));
            transitions1[i].setCycleCount(1);
            transitions1[i].setInterpolator(Interpolator.EASE_BOTH);
        }
        transitions1[0].setByX(300);
        transitions1[1].setByY(300);
        transitions1[2].setByX(-300);
        transitions1[3].setByY(-300);

    RotateTransition[] transitions2 = new RotateTransition[4];

        for (int i = 0; i < 4; i++) {
            transitions2[i] = new RotateTransition();
            transitions2[i].setNode(this.movingRectangle);
            transitions2[i].setDuration(Duration.millis(300));
            transitions2[i].setByAngle(90);
            transitions2[i].setCycleCount(1);
        }
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.setCycleCount(Animation.INDEFINITE);

        for (int i = 0; i < 4; i++) {
            sequentialTransition.getChildren().addAll(transitions1[i], transitions2[i]);

        }

        sequentialTransition.play();
    }
}




