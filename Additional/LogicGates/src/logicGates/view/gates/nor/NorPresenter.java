package logicGates.view.gates.nor;

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
public class NorPresenter {
    // Attributes
    private final LogicGates model;
    private final NorView norView;

    // Constructors
    public NorPresenter(LogicGates model, NorView norView) {
        this.model = model;
        this.norView = norView;
        this.addEventHandlers();
    }

    // Methods
    private void addEventHandlers() {
        this.norView.getFinished().setOnAction(event -> {
            boolean output = this.model.NOR_Gate(this.norView.getInput1().isSelected(), this.norView.getInput2().isSelected());
            if (output) {
                this.norView.getOutput().setText("True");
                this.norView.getOutput().setId("True");
            } else {
                this.norView.getOutput().setText("False");
                this.norView.getOutput().setId("False");
            }
        });
        this.norView.getMiBack().setOnAction(event -> {
            WelcomeView welcomeView = new WelcomeView();
            new WelcomePresenter(this.model, welcomeView);
            Scene scene = this.norView.getScene();
            scene.setRoot(welcomeView);
            Stage stage = (Stage) scene.getWindow();
            stage.setTitle("Welcome");
            stage.show();
        });
        this.norView.getMiExit().setOnAction(event -> Platform.exit());
    }
}