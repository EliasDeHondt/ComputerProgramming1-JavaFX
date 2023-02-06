import javafx.application.Application;
import javafx.stage.Stage;
import be.kdg.dictee.model.Dobbelen;
import be.kdg.dictee.view.DobbelenView;
import be.kdg.dictee.view.Presenter;

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
