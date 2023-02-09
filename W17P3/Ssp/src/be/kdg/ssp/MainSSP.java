package be.kdg.ssp;

import be.kdg.ssp.model.SSPEngine;
import be.kdg.ssp.view.SSPPresenter;
import be.kdg.ssp.view.SSPView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainSSP extends Application {
    @Override
    public void start(Stage primaryStage) {
        SSPEngine model = new SSPEngine();
        SSPView view = new SSPView();
        new SSPPresenter(model, view);
        primaryStage.setTitle("Steen Schaar Papier");
        primaryStage.setScene(new Scene(view));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
