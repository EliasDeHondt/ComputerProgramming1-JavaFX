import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Pensioen;
import view.PensioenPresenter;
import view.PensioenView;

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
