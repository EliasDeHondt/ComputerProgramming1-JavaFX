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

        // 2.1 Voeg de view toe in een Scene op de primaryStage.
        Scene scene = new Scene(view);

        // 2.2 Zorg ervoor dat de app als titel “Colour” krijgt.
        primaryStage.setTitle("Colour");

        primaryStage.setScene(scene);

        // 2.3 Zet de afmetingen met setWidth en setHeight op respectievelijk 400 en 245 pixels.
        primaryStage.setWidth(400);
        primaryStage.setHeight(245);

        // 2.3 Toon de primaryStage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
