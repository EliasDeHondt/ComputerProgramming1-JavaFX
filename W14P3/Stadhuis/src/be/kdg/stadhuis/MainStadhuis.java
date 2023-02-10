package be.kdg.stadhuis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import be.kdg.stadhuis.view.Presenter;
import be.kdg.stadhuis.view.StadhuisPane;

public class MainStadhuis extends Application {
    @Override
    public void start(Stage primaryStage) {
        final StadhuisPane view = new StadhuisPane();
        final Presenter presenter = new Presenter(view);
        primaryStage.setTitle("Stadhuis");
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch();
    }
}
