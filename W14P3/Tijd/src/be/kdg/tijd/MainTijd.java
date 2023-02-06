package be.kdg.tijd;

import be.kdg.tijd.model.TimeModel;
import be.kdg.tijd.view.Presenter;
import be.kdg.tijd.view.TimeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTijd extends Application {
    @Override
    public void start(Stage primaryStage) {
        final TimeModel model = new TimeModel();
        final TimeView view =  new TimeView();
        new Presenter(model, view);
        primaryStage.setTitle("Tijd");
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
