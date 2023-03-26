package logicGates.view.gates.and;

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
public class AndPresenter {
    // Attributes
    private final LogicGates model;
    private final AndView andView;

    // Constructors
    public AndPresenter(LogicGates model, AndView andView) {
        this.model = model;
        this.andView = andView;
        this.addEventHandlers();
    }

    // Methods
    private void addEventHandlers() {
        this.andView.getFinished().setOnAction(event -> {
            boolean output = this.model.AND_Gate(this.andView.getInput1().isSelected(), this.andView.getInput2().isSelected());
            if (output) {
                this.andView.getOutput().setText("True");
                this.andView.getOutput().setId("True");
            } else {
                this.andView.getOutput().setText("False");
                this.andView.getOutput().setId("False");
            }
        });
        this.andView.getMiBack().setOnAction(event -> {
            WelcomeView welcomeView = new WelcomeView();
            new WelcomePresenter(this.model, welcomeView);
            Scene scene = this.andView.getScene();
            scene.setRoot(welcomeView);
            Stage stage = (Stage) scene.getWindow();
            stage.setTitle("Welcome");
            stage.show();
        });
        this.andView.getMiExit().setOnAction(event -> Platform.exit());
    }
}