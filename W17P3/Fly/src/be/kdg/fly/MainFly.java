package be.kdg.fly;

import be.kdg.fly.view.FlyPane;
import be.kdg.fly.view.FlyPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFly extends Application {
    @Override
    public void start(Stage primaryStage) {
        FlyPane view = new FlyPane();
        new FlyPresenter(view);
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Fly");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
