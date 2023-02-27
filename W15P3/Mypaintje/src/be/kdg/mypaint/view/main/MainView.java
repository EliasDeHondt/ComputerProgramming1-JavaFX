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
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        //TODO alle controls initialiseren
    }

    private void layoutNodes() {
        super.setCenter(canvas);
        super.setBottom(lblStatus);
        //TODO Menu opbouwen:

        //TODO Linker toolbox opbouwen:

    }

    //GETTERS (package private):
    Label getLblStatus() {
        return lblStatus;
    }

    Canvas getCanvas() {
        return canvas;
    }

    Slider getSlPensize() {
        return slPensize;
    }

    MenuItem getMiSave() {
        return miSave;
    }

    MenuItem getMiLoad() {
        return miLoad;
    }

    ColorPicker getColorPicker() {
        return colorPicker;
    }

    MenuItem getMiAbout() {
        return miAbout;
    }

    Button getBtnClear() {
        return btnClear;
    }

    Button getBtnUndo() {
        return btnUndo;
    }
}
