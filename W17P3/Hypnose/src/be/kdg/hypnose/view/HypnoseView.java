package be.kdg.hypnose.view;

import javafx.animation.Animation;
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
        // 3.1 Maak een nieuwe lokale variabele aan van het type RotateTransition.
        RotateTransition rotateTransition = new RotateTransition();

        // 3.2 De transitie moet werken met de Node genaamd disc. (methode setNode of via constructor).
        rotateTransition.setNode(this.disc);

        // 3.3 Zorg voor een draaihoek van 360°.
        rotateTransition.setByAngle(360);

        // 3.4 Zorg er voor dat een cyclus anderhalve second duurt.
        rotateTransition.setDuration(Duration.seconds(1.5));

        // 3.5 Zorg er voor dat er oneindig aantal cycli plaatsvinden.
        rotateTransition.setCycleCount(Animation.INDEFINITE);

        // 3.6 Zorg voor een lineaire interpolatie. (methode setInterpolator).
        rotateTransition.setInterpolator(Interpolator.LINEAR);

        // 3.7 play
        rotateTransition.play();
    }
}
