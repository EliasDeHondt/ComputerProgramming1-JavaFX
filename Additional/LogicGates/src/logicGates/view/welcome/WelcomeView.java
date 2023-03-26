package logicGates.view.welcome;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * @author Elias De Hondt
 * @since 26/03/2023
 */
public class WelcomeView extends GridPane {
    // Attributes
    private Image imgLogo;
    private Button[] btnGate;

    // Constructors
    public WelcomeView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    // Methods

    private void initialiseNodes() {
        this.imgLogo = new Image("/logo.png");
        this.btnGate = new Button[7];

        for (int i = 0; i < this.btnGate.length; i++) {
            this.btnGate[i] = new Button("Gate " + (i+1));
            this.btnGate[i].setId("button");
        }
    }

    private void layoutNodes() {
        this.setPadding(new Insets(20));
        this.setVgap(10);
        this.setId("pane");

        this.add(new ImageView(this.imgLogo), 0,0);

        for (int i = 0; i < this.btnGate.length; i++) {
            this.add(this.btnGate[i], 0, (i+1));
        }
    }

    Button[] getBtnGate() {
        return this.btnGate;
    }
}
