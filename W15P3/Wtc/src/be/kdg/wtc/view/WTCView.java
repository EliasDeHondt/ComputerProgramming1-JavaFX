package be.kdg.wtc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class WTCView extends VBox {
    private static final Image BEFORE = new Image("/be/kdg/wtc/resources/images/before.jpg");
    private static final Image AFTER = new Image("/be/kdg/wtc/resources/images/after.jpg");

    private static final double IMAGE_WIDTH = 900.0;
    private static final double IMAGE_HEIGHT = 595.0;

    private Canvas canvas;
    private Slider slider;

    public WTCView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.canvas = new Canvas(400,300);
        this.slider = new Slider(0, 1, 0.5);
    }

    private void layoutNodes() {
        this.canvas.setWidth(IMAGE_WIDTH);
        this.canvas.setHeight(IMAGE_HEIGHT);
        this.slider.setMinWidth(IMAGE_WIDTH + 14.0);

        this.setSpacing(5.0);
        this.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
        this.setAlignment(Pos.CENTER);

        this.getChildren().add(this.canvas);
        this.getChildren().add(this.slider);
    }

    Slider getSlider() {
        return this.slider;
    }

    void updateCanvas() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        this.slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            double opacity = newValue.doubleValue();
            gc.setGlobalAlpha(1 - opacity);
            gc.drawImage(BEFORE, 0, 0);
            gc.setGlobalAlpha(opacity);
            gc.drawImage(AFTER, 0, 0);
        });
    }
}
