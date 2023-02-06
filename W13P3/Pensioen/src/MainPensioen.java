import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import be.kdg.dictee.model.Pensioen;
import be.kdg.dictee.view.PensioenPresenter;
import be.kdg.dictee.view.PensioenView;

public class MainPensioen extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pensioen model = new Pensioen();
        PensioenView view = new PensioenView();
        PensioenPresenter presenter = new PensioenPresenter(model, view);
        Scene scene = new Scene(view);

        // Hier nog de hoofding (titel) instellen

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
