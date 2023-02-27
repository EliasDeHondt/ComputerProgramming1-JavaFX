import graphics.Painting;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        //geen model, geen presenter, enkel een view
        primaryStage.setScene(new Scene(new Painting()));
        primaryStage.setTitle("Grafische probeersels");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
