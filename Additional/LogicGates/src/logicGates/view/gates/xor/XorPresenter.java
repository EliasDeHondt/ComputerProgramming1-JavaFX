package logicGates.view.gates.xor;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logicGates.model.LogicGates;
import logicGates.view.welcome.WelcomePresenter;
import logicGates.view.welcome.WelcomeView;

/**
 * @author Elias De Hondt
 * @since 26/03/2023
 */
public class XorPresenter {
    // Attributes
    private final LogicGates model;
    private final XorView xorView;

    // Constructors
    public XorPresenter(LogicGates model, XorView xorView) {
        this.model = model;
        this.xorView = xorView;
        this.addEventHandlers();
    }

    // Methods
    private void addEventHandlers() {
        this.xorView.getFinished().setOnAction(event -> {
            boolean output = this.model.XOR_Gate(this.xorView.getInput1().isSelected(), this.xorView.getInput2().isSelected());
            if (output) {
                this.xorView.getOutput().setText("True");
                this.xorView.getOutput().setId("True");
            } else {
                this.xorView.getOutput().setText("False");
                this.xorView.getOutput().setId("False");
            }
        });
        this.xorView.getMiBack().setOnAction(event -> {
            WelcomeView welcomeView = new WelcomeView();
            new WelcomePresenter(this.model, welcomeView);
            Scene scene = this.xorView.getScene();
            scene.setRoot(welcomeView);
            Stage stage = (Stage) scene.getWindow();
            stage.setTitle("Welcome");
            stage.show();
        });
        this.xorView.getMiExit().setOnAction(event -> Platform.exit());
    }

}
