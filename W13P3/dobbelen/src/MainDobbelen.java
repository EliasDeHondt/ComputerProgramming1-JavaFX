import be.kdg.dobbelen.model.Dobbelen;
import be.kdg.dobbelen.view.DobbelenView;
import be.kdg.dobbelen.view.Presenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainDobbelen extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Dobbelen model = new Dobbelen();
        DobbelenView view = new DobbelenView();
        Presenter presenter = new Presenter(model, view);
        //TODO
    }

    public static void main(String[] args) {
        launch(args);
    }
}
