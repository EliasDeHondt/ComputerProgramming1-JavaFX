import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import be.kdg.pensioen.model.Pensioen;
import be.kdg.pensioen.view.PensioenPresenter;
import be.kdg.pensioen.view.PensioenView;

public class MainPensioen extends Application {
    @Override
    public void start(Stage primaryStage) {
        // (Is gegeven) Maak model (Pensioen)
        Pensioen model = new Pensioen();

        // (Is gegeven) Maak view (PensioenView)
        PensioenView view = new PensioenView();

        // (Is gegeven) Maak presenter (PensioenPresenter)
        PensioenPresenter presenter = new PensioenPresenter(model, view);

        // (Is gegeven) Maak en scene van de view (PensioenView)
        Scene scene = new Scene(view);

        // 2.1 Voeg de view toe in een Scene op de primaryStage.
        primaryStage.setScene(scene);

        // 2.2 Zorg ervoor dat de app als titel "Pensioenjaar" krijgt.
        primaryStage.setTitle("Pensioenjaar");

        // x
        primaryStage.setHeight(150);
        primaryStage.setWidth(500);

        // 2.3 Toon de primaryStage.
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
