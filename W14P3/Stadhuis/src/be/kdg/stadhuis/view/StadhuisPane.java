package be.kdg.stadhuis.view;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class StadhuisPane extends VBox {
    private static final Image IMAGE = new Image("/stadhuis.jpg");

    private ImageView imageView;
    private RadioButton normal;
    private RadioButton blackAndWhite;
    private RadioButton sepia;

    void resetEffect() {
        this.imageView.setEffect(null);
    }

    void applyBlackAndWhiteEffect() {
        ColorAdjust blackAndWhite = new ColorAdjust();
        blackAndWhite.setSaturation(-1.0);
        this.imageView.setEffect(blackAndWhite);
    }

    void applySepiaEffect() {
        SepiaTone sepiaTone = new SepiaTone();
        sepiaTone.setLevel(0.8);
        this.imageView.setEffect(sepiaTone);
    }
}
