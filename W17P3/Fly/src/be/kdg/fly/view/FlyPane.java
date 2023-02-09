package be.kdg.fly.view;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;

public class FlyPane extends VBox {
    private Canvas canvas;

    public FlyPane() {
        this.initialiseNode();
        this.layoutNodes();
    }

    private void initialiseNode() {
        this.canvas = new Canvas(250, 250);
    }

    private void layoutNodes() {
        this.setSpacing(15.0);
        this.setPadding(new Insets(15.0, 15.0, 15.0, 15.0));
        this.setStyle("-fx-background-color: darkblue");
        this.getChildren().add(this.canvas);
    }

    Canvas getCanvas() {
        return canvas;
    }
}
