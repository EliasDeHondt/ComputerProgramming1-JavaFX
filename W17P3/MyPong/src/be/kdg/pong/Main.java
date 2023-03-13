package be.kdg.pong;

import be.kdg.pong.model.Pong;
import be.kdg.pong.view.PongPresenter;
import be.kdg.pong.view.PongView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Pong model = new Pong();
        PongView view = new PongView();
        PongPresenter presenter = new PongPresenter(model, view);
        Scene scene = new Scene(view);
        stage.setScene(scene);
        stage.setTitle("Pong");
        stage.setWidth(Pong.FIELD_WIDTH + 20);
        stage.setHeight(Pong.FIELD_HEIGHT + 100);
        stage.setResizable(false);
        stage.show();
    }
}
