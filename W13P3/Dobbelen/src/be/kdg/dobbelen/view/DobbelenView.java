package be.kdg.dobbelen.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class DobbelenView extends BorderPane {
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
        // 3.2.1 Maak gebruik van de add methode van de klasse GridPane om de twee images en de knop op de juiste plaats te krijgen. De knop overspant twee kolommen.
        GridPane grid1 = new GridPane();
        grid1.add(this.butWerp, 1,2);
        grid1.add(this.imgDobel1,0,0);
        grid1.add(this.imgDobel2,2,0);

        // 3.2.2 Zorg voor een horizontale en verticale “gap” van 10 pixels tussen de cellen van de GridPane. Zorg ook voor een “padding” van 10 pixels.
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(10));
        this.setLeft(this.imgDobel1);
        this.setCenter(this.butWerp);
        this.setRight(this.imgDobel2);
        BorderPane.setAlignment(this.imgDobel1, Pos.CENTER_LEFT);
        BorderPane.setAlignment(this.butWerp, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(this.imgDobel2, Pos.CENTER_RIGHT);
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
