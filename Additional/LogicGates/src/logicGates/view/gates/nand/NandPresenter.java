package logicGates.view.gates.nand;

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
public class NandPresenter {
    // Attributes
    private final LogicGates model;
    private final NandView nandView;

    // Constructors
    public NandPresenter(LogicGates model, NandView nandView) {
        this.model = model;
        this.nandView = nandView;
        this.addEventHandlers();
    }

    // Methods
    private void addEventHandlers() {
        this.nandView.getFinished().setOnAction(event -> {
            boolean output = this.model.NAND_Gate(this.nandView.getInput1().isSelected(), this.nandView.getInput2().isSelected());
            if (output) {
                this.nandView.getOutput().setText("True");
                this.nandView.getOutput().setId("True");
            } else {
                this.nandView.getOutput().setText("False");
                this.nandView.getOutput().setId("False");
            }
        });
        this.nandView.getMiBack().setOnAction(event -> {
            WelcomeView welcomeView = new WelcomeView();
            new WelcomePresenter(this.model, welcomeView);
            Scene scene = this.nandView.getScene();
            scene.setRoot(welcomeView);
            Stage stage = (Stage) scene.getWindow();
            stage.setTitle("Welcome");
            stage.show();
        });
        this.nandView.getMiExit().setOnAction(event -> Platform.exit());
    }
}