import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import be.kdg.dobbelen.model.Dobbelen;
import be.kdg.dobbelen.view.DobbelenView;
import be.kdg.dobbelen.view.Presenter;

public class MainDobbelen extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Maak new model (Dobbelen)
        Dobbelen model = new Dobbelen();

        // Maak new view (DobbelenView)
        DobbelenView view = new DobbelenView();

        // Maak new presenter (Presenter)
        Presenter presenter = new Presenter(model, view);

        // Maak new scene van view
        Scene scene = new Scene(view);

        // 2.1 Voeg de view toe in een Scene op de primaryStage.
        primaryStage.setScene(scene);

        // 2.2 Zorg ervoor dat de app als titel "Dobbelen" krijgt.
        primaryStage.setTitle("Dobbelen");

        // x
        primaryStage.setHeight(200);
        primaryStage.setWidth(250);

        // x
        primaryStage.getIcons().add(new Image("be\\kdg\\dobbelen\\view\\images\\die6.png"));

        // 2.3  Toon de primaryStage.
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
