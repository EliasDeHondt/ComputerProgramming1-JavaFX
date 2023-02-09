package be.kdg.wtc;

import be.kdg.wtc.view.Presenter;
import be.kdg.wtc.view.WTCView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//
// http://www.huffingtonpost.co.uk/2014/09/11/911-anniversary-incredible-before-and-after-pictures-show-new-york-was-rebuilt-after-attacks_n_5802376.html
//

public class MainWTC extends Application {
    @Override
    public void start(Stage primaryStage) {
        WTCView view = new WTCView();
        new Presenter(view);
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("New York - Before and After 9/11");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
