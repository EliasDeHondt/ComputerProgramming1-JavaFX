package be.kdg.background.view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class View extends BorderPane {
    // Attributes
    private Button changeButton;
    // Constructors
    public View() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    // Methods
    public void initialiseNodes() {
        // 3.1.1 Voorzie het attribuut van een waarde.
        this.changeButton = new Button("Change Colour");
    }
    public void layoutNodes() {
        this.setCenter(this.changeButton);
        // 3.2.1 Maak gebruik van de juiste set… methode van de klasse BorderPane om de component op de juiste plaats te krijgen.
        setAlignment(this.changeButton, Pos.BOTTOM_RIGHT);

        // 3.2.2 Zorg voor een "padding" van 10 pixels.
        setPadding(new Insets(10));
    }
    Button getChangeButton() { // Get..
        return this.changeButton;
    }
}
