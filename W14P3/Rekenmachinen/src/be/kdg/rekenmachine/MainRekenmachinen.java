package be.kdg.rekenmachine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import be.kdg.rekenmachine.model.Calculator;
import be.kdg.rekenmachine.view.CalculatorPane;
import be.kdg.rekenmachine.view.Presenter;

public class MainRekenmachinen extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Calculator model = new Calculator();
        CalculatorPane view = new CalculatorPane();

        new Presenter(model, view);

        primaryStage.setTitle("Rekenmachinen");
        primaryStage.setScene(new Scene(view));
        primaryStage.getIcons().add(new Image("be/kdg/rekenmachine/resources/icon.png"));
        primaryStage.show();
    }
}
