import be.kdg.scramble.model.Scrambler;
import be.kdg.scramble.view.Presenter;
import be.kdg.scramble.view.ScramblerView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainScramble extends Application {
    @Override
    public void start(Stage stage) {
        // 2.3 Maak een nieuw model-, view- en presenter-object aan.
        Scrambler model = new Scrambler();
        ScramblerView view = new ScramblerView();
        new Presenter(model,view);
        // 2.4 Voeg de view toe in een Scene op de Stage.
        Scene scene = new Scene(view);
        stage.setScene(scene);
        // 2.5 Zorg ervoor dat de Stage de juiste titel krijgt.
        stage.setTitle("Scramble");
        // x
        stage.setHeight(130);
        stage.setWidth(250);
        // Toon de Stage.
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
