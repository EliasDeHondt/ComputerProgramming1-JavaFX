package be.kdg.stopwatch;

import be.kdg.stopwatch.model.StopwatchModel;
import be.kdg.stopwatch.view.StopwatchPresenter;
import be.kdg.stopwatch.view.StopwatchView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        final StopwatchModel model = new StopwatchModel();
        final StopwatchView view = new StopwatchView();
        new StopwatchPresenter(model, view);

        primaryStage.setTitle("Stopwatch");
        primaryStage.setScene(new Scene(view));
        primaryStage.setWidth(418);
        primaryStage.setHeight(200);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
