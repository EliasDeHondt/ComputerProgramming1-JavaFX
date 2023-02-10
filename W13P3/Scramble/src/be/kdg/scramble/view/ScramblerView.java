package be.kdg.scramble.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ScramblerView extends GridPane { // 3. Deze klasse erft van GridPane.
    // Attributes
    // 3. De controls moeten toegevoegd worden als attributen. Raadpleeg de wireframe om te weten welke controls je nodig hebt.
    private TextField textField;
    private Button  button;
    // Constructors
    public ScramblerView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    // Methods
    // 3.1 Voeg een methode genaamd initialiseNodes toe aan ScramblerView en roep deze methode op in de constructor.
    public void initialiseNodes() {
        // 3.2 In de methode zelf initialiseer je de controls die je als attributen hebt aangemaakt.
        this.textField = new TextField();
        this.button = new Button("Scramble");
    }
    public void layoutNodes() {
        // 3.2.1 Maak gebruik van de add methode van de klasse GridPane om de controls op de juiste plaats te krijgen.
        // this.setGridLinesVisible(true);
        // (0,0) (1,0) (2,0)
        // (0,1) (1,1) (2,1)
        // (0,2) (1,2) (2,2)
        this.add(this.textField, 0,0);
        this.add(this.button, 0,1);
        // 3.2.2 Zorg voor een horizontale en verticale “gap” van 10 pixels tussen de cellen van de GridPane.
        this.setHgap(10);
        this.setVgap(10);
        // 3.2.2 Zorg ook voor een “padding” van 10 pixels.
        this.setPadding(new Insets(10));
    }
    Button getButton() { // Get..
        return this.button;
    }
    TextField getTextField() { // Get..
        return this.textField;
    }
}
