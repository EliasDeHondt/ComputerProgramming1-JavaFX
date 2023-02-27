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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.util.List;
import java.util.Optional;

public class MainPresenter {
    private PaintModel model;
    private MainView view;

    public MainPresenter(PaintModel model, MainView view) {
        this.model = model;
        this.view = view;
        addEventhandlers();
        updateView();
    }

    private void addEventhandlers() {
        //TODO MouseEvents afhandelen
        //TODO ButtonEvents afhandelen
        //TODO MenuEvents afhandelen
        //TODO WindowClose event afhandelen
    }

    private void updateView() {
        //TODO Points ophalen van model en tekenen op canvas
    }
}
