package be.kdg;

import be.kdg.model.SpelModel;
import be.kdg.view.SettingsPresenter;
import be.kdg.view.SettingsView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SpelModel model = new SpelModel();
        SettingsView view = new SettingsView();
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mastermind");
        primaryStage.setResizable(false);
        new SettingsPresenter(model, view);
        primaryStage.show();
    }
}
