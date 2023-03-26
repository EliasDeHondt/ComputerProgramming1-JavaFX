package logicGates.view.gates.not;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import logicGates.view.gates.GateView;

/**
 * @author Elias De Hondt
 * @since 26/03/2023
 */
public class NotView extends GateView {
    // Attributes
    private MenuItem miBack, miExit;
    private Label name, output;
    private Image ImgGate;
    private CheckBox input1;
    private Button finished;

    // Constructors
    public NotView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    // Methods
    private void initialiseNodes() {
        this.miBack = new MenuItem("Back");
        this.miExit = new MenuItem("Exit");

        this.name = new Label("The NOT gate");
        this.output = new Label();
        this.ImgGate = new Image("/NOT_Gate.png");

        this.input1 = new CheckBox("Input 1");
        this.finished = new Button("Finished");
    }

    private void layoutNodes() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setVgap(10);

        this.setId("pane");
        this.setCenter(gridPane);

        // Menu opbouwen:
        Menu menu = new Menu("Help");
        menu.getItems().addAll(this.miBack, this.miExit);
        MenuBar menuBar = new MenuBar(menu);

        this.setTop(menuBar);

        this.name.setId("label");
        this.output.setId("label");
        this.input1.setId("check-box");
        this.finished.setId("btnFinished");

        gridPane.add(this.name, 0, 0);
        gridPane.add(new ImageView(this.ImgGate), 0, 1);
        gridPane.add(this.input1, 0, 2);
        gridPane.add(this.finished, 0, 3);
        gridPane.add(this.output, 0, 4);
    }

    MenuItem getMiBack() {
        return this.miBack;
    }

    MenuItem getMiExit() {
        return this.miExit;
    }

    Label getOutput() {
        return this.output;
    }

    CheckBox getInput1() {
        return this.input1;
    }

    Button getFinished() {
        return this.finished;
    }
}