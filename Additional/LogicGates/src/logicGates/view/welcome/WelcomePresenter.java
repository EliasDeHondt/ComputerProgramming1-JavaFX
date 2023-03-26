package logicGates.view.welcome;

import javafx.scene.Scene;
import javafx.stage.Stage;
import logicGates.model.LogicGates;
import logicGates.view.gates.GateView;
import logicGates.view.gates.and.*;
import logicGates.view.gates.nand.*;
import logicGates.view.gates.nor.*;
import logicGates.view.gates.not.*;
import logicGates.view.gates.or.*;
import logicGates.view.gates.xnor.*;
import logicGates.view.gates.xor.*;

/**
 * @author Elias De Hondt
 * @since 26/03/2023
 */
public class WelcomePresenter {
    // Attributes
    private final LogicGates model;
    private final WelcomeView welcomeView;

    // Constructors
    public WelcomePresenter(LogicGates model, WelcomeView welcomeView) {
        this.model = model;
        this.welcomeView = welcomeView;
        this.addEventHandlers();
    }

    // Methods
    private void addEventHandlers() {
        String[] gateNames = {"AND Gate", "NAND Gate", "NOR Gate", "NOT Gate", "OR Gate", "XNOR Gate", "XOR Gate"};

        for (int i = 0; i < gateNames.length; i++) {
            GateView gateView = null;

            switch (i) {
                case 0 -> {
                    gateView = new AndView();
                    new AndPresenter(this.model, (AndView) gateView);
                }
                case 1 -> {
                    gateView = new NandView();
                    new NandPresenter(this.model,(NandView) gateView);
                }
                case 2 -> {
                    gateView = new NorView();
                    new NorPresenter(this.model, (NorView) gateView);
                }
                case 3 -> {
                    gateView = new NotView();
                    new NotPresenter(this.model, (NotView) gateView);
                }
                case 4 -> {
                    gateView = new OrView();
                    new OrPresenter(this.model, (OrView) gateView);
                }
                case 5 -> {
                    gateView = new XnorView();
                    new XnorPresenter(this.model, (XnorView) gateView);
                }
                case 6 -> {
                    gateView = new XorView();
                    new XorPresenter(this.model, (XorView) gateView);
                }
            }

            final int gateIndex = i;
            GateView finalGateView = gateView;
            this.welcomeView.getBtnGate()[i].setOnAction(event -> {
                Scene scene = this.welcomeView.getScene();
                scene.getWindow().sizeToScene();
                scene.setRoot(finalGateView);

                Stage stage = (Stage) scene.getWindow();
                stage.setTitle(gateNames[gateIndex]);
                stage.show();
            });
        }
    }

}
