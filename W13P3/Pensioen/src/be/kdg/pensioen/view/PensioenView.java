package be.kdg.pensioen.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * LEFT: geboorteJaar
 * CENTER: berekenButton
 * RIGHT: pensioenJaar
 * Insets: TRouBLe
 */
public class PensioenView extends BorderPane {
    // Attributes
    private TextField geboorteJaarField;
    private TextField dataField;
    private Button berekenButton;
    // Constructors
    public PensioenView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    // Methods
    public void initialiseNodes() {
        // 3.1.1 Voorzie de drie attributen van een waarde.
        this.geboorteJaarField = new TextField();
        this.dataField = new TextField();
        this.berekenButton = new Button("Bereken");

        // 3.1.2 Het 2de tekstveld mag niet editeerbaar zijn.
        this.dataField.setEditable(false);

        // 3.1.3 Beide velden hebben bij voorkeur 4 kolommen.
        GridPane txtGrid = new GridPane();
        txtGrid.add(this.dataField, 0,0,3,3);
    }
    public void layoutNodes() {
        // 3.2.1 Maak gebruik van de juiste set… methode van de klasse BorderPane om de componenten op de juiste plaats te krijgen.
        this.setLeft(this.geboorteJaarField);
        this.setCenter(this.berekenButton);
        this.setRight(this.dataField);

        BorderPane.setAlignment(this.geboorteJaarField, Pos.CENTER_LEFT);
        BorderPane.setAlignment(this.berekenButton, Pos.CENTER);
        BorderPane.setAlignment(this.dataField, Pos.CENTER_RIGHT);

        // 3.2.2 Zorg voor een horizontale en verticale “marge” van 10 pixels tussen de cellen van de BorderPane.
        // Zorg ook voor een “padding” van 10 pixels.
        BorderPane.setMargin(this.geboorteJaarField, new Insets(10)); // Marge
        BorderPane.setMargin(this.berekenButton, new Insets(10)); // Marge
        BorderPane.setMargin(this.dataField, new Insets(10)); // Marge
        this.geboorteJaarField.setPadding(new Insets(10)); // Padding
        this.berekenButton.setPadding(new Insets(10)); // Padding
        this.dataField.setPadding(new Insets(10)); // Padding
    }
    Button getBerekenButton() { // Get..
        return this.berekenButton;
    }
    TextField getGeboorteJaarField() { // Get..
        return this.geboorteJaarField;
    }
    public void setDataField(String pensioenJaar) { // Set..
        this.dataField.setText(pensioenJaar);
    }
}
