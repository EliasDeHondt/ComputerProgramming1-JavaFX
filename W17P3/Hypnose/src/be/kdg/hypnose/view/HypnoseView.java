package be.kdg.hypnose.view;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class HypnoseView extends BorderPane {
    private ImageView disc;

    public HypnoseView() {
        this.initialiseNodes();
        this.layoutNodes();
        this.animate();
    }

    private void initialiseNodes() {
        this.disc = new ImageView(new Image("be/kdg/hypnose/view/images/hypnotic-disk.jpg"));
    }

    private void layoutNodes() {
        this.setCenter(this.disc);
        BorderPane.setMargin(this.disc, new Insets(-103.0, 0.0, 0.0, -103.0));
    }

    private void animate() {
        // Hier aanvullen...
    }
}
