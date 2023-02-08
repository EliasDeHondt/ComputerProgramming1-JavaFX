package be.kdg.dobbelen.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class DobbelenView extends GridPane {
    // Attributes
    // 3.0.1 We hebben drie controls nodig: twee ImageView controls en een Button control. Maak deze controls aan als attributen.
    private ImageView imgDobel1;
    private ImageView imgDobel2;
    private Button butWerp;
    // Constructors
    public DobbelenView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    // Methods
    private void initialiseNodes() {
        // 3.1.1 Voorzie de drie attributen van een waarde.
        this.imgDobel1 = new ImageView();
        this.imgDobel2 = new ImageView();
        this.butWerp = new Button("Werp");
        // 3.1.2 De knop moet een geprefereerde breedte van 80 pixels hebben.
        this.butWerp.prefWidth(80);
    }
    private void layoutNodes() {
        // x
        this.setStyle("-fx-background-color: #000000");
        // 3.2.1 Maak gebruik van de add methode van de klasse GridPane om de twee images en de knop op de juiste plaats te krijgen.
        // De knop overspant twee kolommen.
        this.add(this.butWerp,1,2);
        this.add(this.imgDobel1,0,1);
        this.add(this.imgDobel2,2,1);
        // (0,0) (1,0) (2,0)
        // (0,1) (1,1) (2,1)
        // (0,2) (1,2) (2,2)

        // 3.2.2 Zorg voor een horizontale en verticale "gap" van 10 pixels tussen de cellen van de GridPane.
        this.setHgap(10);
        this.setVgap(10);
        // 3.2.2 Zorg ook voor een "padding" van 10 (20) pixels.
        this.setPadding(new Insets(20));
    }
    Button getButWerp() { // Get..
        return this.butWerp;
    }
    public void setImgDobel1(String path) { // Set..
        this.imgDobel1.setImage(new Image(path));

    }
    public void setImgDobel2(String path) { // Set..
        this.imgDobel2.setImage(new Image(path));
    }
}
