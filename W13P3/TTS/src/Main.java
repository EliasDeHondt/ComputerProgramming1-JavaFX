import be.kdg.dictee.model.Dictee;
import be.kdg.dictee.view.DicteePresenter;
import be.kdg.dictee.view.DicteeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Elias De Hondt
 * 6/02/2023
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // Maak new View (DicteeView)
        DicteeView view = new DicteeView();

        // Maak new Model (Dictee)
        Dictee model = new Dictee();

        // Maak new Presenter (Dictee)
        DicteePresenter presenter = new DicteePresenter(model, view);

        // Maak new scene van view
        Scene scene = new Scene(view);

        stage.setScene(scene);
        stage.setWidth(250);
        stage.setHeight(400);
        stage.setTitle("Dictee");
        stage.show();



    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
