package be.kdg.mainmenu;

import be.kdg.mainmenu.view.MainMenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMainMenu extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainMenuView view = new MainMenuView();
        primaryStage.setScene(new Scene(view));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Main Menu");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
