/**
 * @author Elias De Hondt
 * @see https://eliasdh.com
 * @since 09/05/2023
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.SerialArduinoConnection;
import view.ArduinoView;
import view.ArduinoPresenter;

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
