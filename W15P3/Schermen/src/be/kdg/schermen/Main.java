package be.kdg.schermen;

import be.kdg.schermen.model.SimpleModel;
import be.kdg.schermen.view.start.StartPresenter;
import be.kdg.schermen.view.start.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        SimpleModel model = new SimpleModel();
        StartView view = new StartView();
        StartPresenter startPresenter = new StartPresenter(model,view);
        Scene scene = new Scene(view);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Ganzenbord");
        primaryStage.setResizable(false);
        startPresenter.voegWindowEventToe();
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
