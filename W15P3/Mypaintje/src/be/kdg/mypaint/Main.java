package be.kdg.mypaint;

import be.kdg.mypaint.model.PaintModel;
import be.kdg.mypaint.view.main.MainPresenter;
import be.kdg.mypaint.view.main.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        PaintModel model = new PaintModel();
        MainView view = new MainView();
        new MainPresenter(model,view);
        stage.setScene(new Scene((view)));
        stage.setTitle("My Paint");
        stage.setWidth(750);
        stage.setHeight(650);
        stage.getIcons().add(new Image("/myPaint.png")); // Making Icon.
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
