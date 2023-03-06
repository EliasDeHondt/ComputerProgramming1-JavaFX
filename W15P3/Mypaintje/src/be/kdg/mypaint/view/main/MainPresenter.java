package be.kdg.mypaint.view.main;

import be.kdg.mypaint.model.PaintModel;
import be.kdg.mypaint.model.Point;
import be.kdg.mypaint.view.about.AboutPresenter;
import be.kdg.mypaint.view.about.AboutView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.*;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class MainPresenter {
    private PaintModel model;
    private MainView view;

    public MainPresenter(PaintModel model, MainView view) {
        this.model = model;
        this.view = view;
        this.addEventhandlers();
        this.updateView();
    }

    private void addEventhandlers() {
        // MouseEvents afhandelen
        this.view.getCanvas().setOnMouseDragged(event -> {
            this.model.addPoint(new Point(
                    (int)event.getX(),
                    (int)event.getY(),
                    (int)this.view.getSlPensize().getValue(),
                    this.view.getColorPicker().getValue()));
            updateView();
        });

        this.view.getCanvas().setOnMouseMoved(event -> {
            this.view.getLblStatus().setText(String.format("x: %.0f y: %.0f",
                    event.getX(), event.getY()));
        });

        // ButtonEvents afhandelen
        this.view.getBtnUndo().setOnAction(actionEvent -> {
            this.model.undo();
            this.updateView();
        });

        this.view.getBtnClear().setOnAction(actionEvent -> {
            this.model.clear();
            this.updateView();
        });

        // MenuEvents afhandelen
        this.view.getMiSave().setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("W15P3/Mypaintje/resources"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Binary Files", "*.bin"));
            File file = fileChooser.showSaveDialog(null);
            this.model.save(file.getAbsolutePath());
        });

        this.view.getMiLoad().setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("W15P3/Mypaintje/resources"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Binary Files", "*.bin"));
            File file = fileChooser.showOpenDialog(null);
            this.model.load(file.getAbsolutePath());
            this.updateView();
        });
    }

    private void updateView() {
        GraphicsContext gc = this.view.getCanvas().getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0, this.view.getCanvas().getWidth(),this.view.getCanvas().getHeight());
        // Points ophalen van model en tekenen op canvas
        for(Point point : this.model.getPoints()) {
            // Kleur
            gc.setFill(point.getColor());
            // Cirkeltje tekenen
            gc.fillOval(point.getX(),point.getY(),point.getPensize(),point.getPensize());
        }
    }
}
