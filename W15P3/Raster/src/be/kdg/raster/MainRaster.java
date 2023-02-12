package be.kdg.raster;

import be.kdg.raster.model.RasterModel;
import be.kdg.raster.view.Presenter;
import be.kdg.raster.view.RasterView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainRaster extends Application {
    @Override
    public void start(Stage primaryStage) {
        RasterModel model = new RasterModel();
        RasterView view = new RasterView();
        new Presenter(model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Raster");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch();
    }
}
