package be.kdg.mypaint.view.main;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import static be.kdg.mypaint.view.Constants.*;

public class MainView extends BorderPane {
    private Label lblStatus;
    private Canvas canvas;
    private MenuItem miSave;
    private MenuItem miLoad;
    private MenuItem miAbout;
    private Slider slPensize;
    private ColorPicker colorPicker;
    private Button btnUndo;
    private Button btnClear;

    public MainView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.lblStatus = new Label("x: .... y: ....");
        this.canvas = new Canvas(500,500);
        this.miSave = new MenuItem("Save");
        this.miLoad = new MenuItem("Load");
        this.miAbout = new MenuItem("About");
        this.slPensize = new Slider(0,20,5);
        this.slPensize.setShowTickLabels(true);
        this.slPensize.setMajorTickUnit(5);
        this.colorPicker = new ColorPicker();
        this.colorPicker.setValue(Color.BLACK);
        this.btnUndo = new Button("Undo");
        this.btnClear = new Button("Clear");
    }

    private void layoutNodes() {
        super.setCenter(canvas);
        super.setBottom(lblStatus);

        // Menu opbouwen:
        Menu mnFile = new Menu("File");
        mnFile.getItems().addAll(this.miLoad,this.miSave);
        Menu mnhelp = new Menu("Help");
        mnhelp.getItems().add(this.miAbout);
        MenuBar menuBar = new MenuBar(mnFile,mnhelp);
        this.setTop(menuBar);

        // Linker toolbox opbouwen:
        Label lblSize = new Label("Pendikte");
        lblSize.setPrefWidth(LABEL_WIDTH);
        this.slPensize.setPrefWidth(CONTROLS_WIDTH);
        HBox hb1 = new HBox(lblSize,this.slPensize);
        hb1.setSpacing(45);

        Label lblColor = new Label("Kleur");
        lblColor.setPrefWidth(LABEL_WIDTH);
        this.colorPicker.setPrefWidth(CONTROLS_WIDTH);
        HBox hb2 = new HBox(lblColor,this.colorPicker);
        hb2.setSpacing(45);

        this.btnUndo.setPrefWidth(LABEL_WIDTH);
        this.btnClear.setPrefWidth(LABEL_WIDTH);
        HBox hb3= new HBox(this.btnUndo,this.btnClear);
        hb3.setSpacing(45);

        VBox vBox = new VBox(hb1,hb2,hb3);
        vBox.setSpacing(DEFAULT_MARGIN);
        this.setLeft(vBox);
        BorderPane.setMargin(vBox,new Insets(DEFAULT_MARGIN));
        BorderPane.setMargin(lblStatus, new Insets(DEFAULT_MARGIN));

    }

    //GETTERS (package private):
    Label getLblStatus() {
        return this.lblStatus;
    }

    Canvas getCanvas() {
        return this.canvas;
    }

    Slider getSlPensize() {
        return this.slPensize;
    }

    MenuItem getMiSave() {
        return this.miSave;
    }

    MenuItem getMiLoad() {
        return this.miLoad;
    }

    ColorPicker getColorPicker() {
        return this.colorPicker;
    }

    MenuItem getMiAbout() {
        return this.miAbout;
    }

    Button getBtnClear() {
        return this.btnClear;
    }

    Button getBtnUndo() {
        return this.btnUndo;
    }
}
