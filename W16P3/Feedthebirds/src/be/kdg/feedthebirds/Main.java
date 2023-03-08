package be.kdg.feedthebirds;

import be.kdg.feedthebirds.view.BirdsPresenter;
import be.kdg.feedthebirds.view.BirdsView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BirdsView view = new BirdsView();
        new BirdsPresenter(view);
        primaryStage.setScene(new Scene(view));
        primaryStage.setWidth(850);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Feed the birds!");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
