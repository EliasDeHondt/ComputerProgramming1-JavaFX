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
    private static final Image IMAGE = new Image("be/kdg/stadhuis/resources/stadhuis.jpg");
    // 3.0.1 Maak voor elk van de drie radiobuttons een attribuut aan van het type RadioButton.
    private RadioButton normal;
    private RadioButton blackAndWhite;
    private RadioButton sepia;
    // 3.0.1 Maak voor de afbeelding een attribuut aan van het type ImageView.
    private ImageView imageView;
    public StadhuisPane() {
        this.initialiseNodes();
        this.layoutNodes();
    }

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
    private void initialiseNodes() {
        // 3.1.1 Initialiseer de vier controls
        this.normal = new RadioButton("Normal");
        this.blackAndWhite = new RadioButton("BlackAndWhite");
        this.sepia = new RadioButton("Sepia");
        this.imageView = new ImageView();
        // 3.1.2 Als je een afbeelding wil toekennen aan een ImageView dan heb je een Image nodig.
        this.imageView.setImage(IMAGE);
        // 3.1.3 Zorg er voor dat de drie radiobuttons in eenzelfde ToggleGroup zitten. De ToggleGroup hoeft geen attribuut te zijn, je kan een lokale variabele gebruiken.
        ToggleGroup group1 = new ToggleGroup();
        this.normal.setToggleGroup(group1);
        this.blackAndWhite.setToggleGroup(group1);
        this.sepia.setToggleGroup(group1);
        // 3.1.4 De knop “Normaal” moet geselecteerd staan.
        this.normal.setScaleShape(true);
        // 3.1.5 Voorzie een ruimte van een 15-tal pixels tussen de verschillende controls. Dit doen we op VBox-niveau.
        VBox.setMargin(this.normal, new Insets(15));
        VBox.setMargin(this.blackAndWhite, new Insets(15));
        VBox.setMargin(this.sepia, new Insets(15));
        VBox.setMargin(this.imageView, new Insets(15));
    }

    private void layoutNodes() {
        // 3.2 Voeg de vier controls toe aan de view. In een VBox is dit heel eenvoudig.
        this.getChildren().add(this.imageView);
        this.getChildren().add(this.normal);
        this.getChildren().add(this.blackAndWhite);
        this.getChildren().add(this.sepia);
    }
    RadioButton getNormal() { // Get..
        return this.normal;
    }
    RadioButton getBlackAndWhite() { // Get..
        return this.blackAndWhite;
    }
    RadioButton getSepia() { // Get..
        return this.sepia;
    }
}
