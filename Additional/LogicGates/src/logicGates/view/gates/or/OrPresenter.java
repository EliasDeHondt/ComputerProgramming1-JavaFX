package logicGates.view.gates.or;

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
public class OrPresenter {
    // Attributes
    private final LogicGates model;
    private final OrView orView;

    // Constructors
    public OrPresenter(LogicGates model, OrView orView) {
        this.model = model;
        this.orView = orView;
        this.addEventHandlers();
    }

    // Methods
    private void addEventHandlers() {
        this.orView.getFinished().setOnAction(event -> {
            boolean output = this.model.OR_Gate(this.orView.getInput1().isSelected(), this.orView.getInput2().isSelected());
            if (output) {
                this.orView.getOutput().setText("True");
                this.orView.getOutput().setId("True");
            } else {
                this.orView.getOutput().setText("False");
                this.orView.getOutput().setId("False");
            }
        });
        this.orView.getMiBack().setOnAction(event -> {
            WelcomeView welcomeView = new WelcomeView();
            new WelcomePresenter(this.model, welcomeView);
            Scene scene = this.orView.getScene();
            scene.setRoot(welcomeView);
            Stage stage = (Stage) scene.getWindow();
            stage.setTitle("Welcome");
            stage.show();
        });
        this.orView.getMiExit().setOnAction(event -> Platform.exit());
    }
}
