package be.kdg.mywoordle;

import be.kdg.mywoordle.model.Woordle;
import be.kdg.mywoordle.view.WoordlePresenter;
import be.kdg.mywoordle.view.WoordleView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Woordle woordle = new Woordle();
        System.out.println("te zoeken: " + woordle.getZoekWoord()); //sneaky preview
        WoordleView view = new WoordleView();
        WoordlePresenter presenter = new WoordlePresenter(woordle, view);

        stage.setScene(new Scene(view));
        stage.setTitle("My Woordle");
        stage.setWidth(300);
        stage.setHeight(520);
        stage.show();
    }
}
