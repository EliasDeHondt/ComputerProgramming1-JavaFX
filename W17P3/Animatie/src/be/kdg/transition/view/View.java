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

    }
}




