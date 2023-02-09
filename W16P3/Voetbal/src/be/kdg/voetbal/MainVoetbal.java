package be.kdg.voetbal;

import be.kdg.voetbal.model.VoetbalModel;
import be.kdg.voetbal.view.Presenter;
import be.kdg.voetbal.view.VoetbalView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//
// http://nieuws.vtm.be/sport/142742-we-gooien-helft-voetbaltalent-weg
//

public class MainVoetbal extends Application {
    @Override
    public void start(Stage primaryStage) {
        VoetbalModel model = new VoetbalModel();
        VoetbalView view = new VoetbalView();
        new Presenter(model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Voetbaltalent");
        primaryStage.setWidth(800.0);
        primaryStage.setHeight(600.0);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
