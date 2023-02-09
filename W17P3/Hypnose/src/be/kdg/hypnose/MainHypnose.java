package be.kdg.hypnose;

import be.kdg.hypnose.view.HypnoseView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainHypnose extends Application {
    @Override
    public void start(Stage primaryStage) {
        final HypnoseView view = new HypnoseView();
        primaryStage.setScene(new Scene(view));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Hypnose");
        primaryStage.setWidth(494.0);
        primaryStage.setHeight(494.0);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
