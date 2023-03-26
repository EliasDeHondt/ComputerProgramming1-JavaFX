package logicGates.view.gates.not;

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
public class NotPresenter {
    // Attributes
    private final LogicGates model;
    private final NotView notView;

    // Constructors
    public NotPresenter(LogicGates model, NotView notView) {
        this.model = model;
        this.notView = notView;
        this.addEventHandlers();
    }

    // Methods
    private void addEventHandlers() {
        this.notView.getFinished().setOnAction(event -> {
            boolean output = this.model.NOT_Gate(this.notView.getInput1().isSelected());
            if (output) {
                this.notView.getOutput().setText("True");
                this.notView.getOutput().setId("True");
            } else {
                this.notView.getOutput().setText("False");
                this.notView.getOutput().setId("False");
            }
        });
        this.notView.getMiBack().setOnAction(event -> {
            WelcomeView welcomeView = new WelcomeView();
            new WelcomePresenter(this.model, welcomeView);
            Scene scene = this.notView.getScene();
            scene.setRoot(welcomeView);
            Stage stage = (Stage) scene.getWindow();
            stage.setTitle("Welcome");
            stage.show();
        });
        this.notView.getMiExit().setOnAction(event -> Platform.exit());
    }
}