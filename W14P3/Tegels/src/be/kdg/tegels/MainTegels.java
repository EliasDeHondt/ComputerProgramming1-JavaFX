package be.kdg.tegels;

import be.kdg.tegels.model.TileModel;
import be.kdg.tegels.view.Presenter;
import be.kdg.tegels.view.TileView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTegels extends Application {
    @Override
    public void start(Stage primaryStage) {
        final TileModel model = new TileModel();
        final TileView view = new TileView();
        new Presenter(model, view);

        primaryStage.setTitle("Tegels");
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
