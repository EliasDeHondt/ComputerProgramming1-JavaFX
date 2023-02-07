import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import be.kdg.background.model.Kleuren;
import be.kdg.background.view.Presenter;
import be.kdg.background.view.View;

public class MainBackground extends Application {
    @Override
    public void start(Stage primaryStage) {
        Kleuren model = new Kleuren();
        View view = new View();
        Presenter presenter = new Presenter(model, view);
        Scene scene = new Scene(view);

        primaryStage.setTitle("Colour");
        primaryStage.setScene(scene);

        // TODO: breedte en hoogte nog aanvullen (zie opgave)

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
