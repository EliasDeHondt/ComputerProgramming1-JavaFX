package be.kdg;


import be.kdg.model.VierOpRij;
import be.kdg.view.game.GamePresenter;
import be.kdg.view.game.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        VierOpRij model = new VierOpRij();
        GameView view = new GameView();
        new GamePresenter(model, view);

        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.setTitle("4 op een rij");
        primaryStage.setMinHeight(420);
        primaryStage.setMinWidth(440);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
