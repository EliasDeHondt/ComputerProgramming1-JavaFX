package logicGates.view.gates.xnor;

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
public class XnorPresenter {
    // Attributes
    private final LogicGates model;
    private final XnorView xnorView;

    // Constructors
    public XnorPresenter(LogicGates model, XnorView xnorView) {
        this.model = model;
        this.xnorView = xnorView;
        this.addEventHandlers();
    }

    // Methods
    private void addEventHandlers() {
        this.xnorView.getFinished().setOnAction(event -> {
            boolean output = this.model.XNOR_Gate(this.xnorView.getInput1().isSelected(), this.xnorView.getInput2().isSelected());
            if (output) {
                this.xnorView.getOutput().setText("True");
                this.xnorView.getOutput().setId("True");
            } else {
                this.xnorView.getOutput().setText("False");
                this.xnorView.getOutput().setId("False");
            }
        });
        this.xnorView.getMiBack().setOnAction(event -> {
            WelcomeView welcomeView = new WelcomeView();
            new WelcomePresenter(this.model, welcomeView);
            Scene scene = this.xnorView.getScene();
            scene.setRoot(welcomeView);
            Stage stage = (Stage) scene.getWindow();
            stage.setTitle("Welcome");
            stage.show();
        });
        this.xnorView.getMiExit().setOnAction(event -> Platform.exit());
    }
}
