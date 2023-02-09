package be.kdg.engels;

import be.kdg.engels.model.EngelsModel;
import be.kdg.engels.view.EngelsView;
import be.kdg.engels.view.Presenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainEngels extends Application {
    @Override
    public void start(Stage primaryStage) {
        final EngelsModel model = new EngelsModel();
        final EngelsView view = new EngelsView();
        new Presenter(model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Engels");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
