package be.kdg.helloarduino;

import be.kdg.helloarduino.model.SerialArduinoConnection;
import be.kdg.helloarduino.view.ArduinoView;
import be.kdg.helloarduino.view.ArduinoPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        SerialArduinoConnection connection = new SerialArduinoConnection();
        ArduinoView view = new ArduinoView();
        new ArduinoPresenter(connection, view);
        stage.setScene(new Scene(view));
        stage.show();
    }
}
