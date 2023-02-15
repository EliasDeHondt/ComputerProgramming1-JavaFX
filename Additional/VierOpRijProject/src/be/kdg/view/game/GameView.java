package be.kdg.view.game;

import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class GameView extends BorderPane {
    static final int RIJEN = 6;
    static final int KOLOMMEN = 7;

    private MenuItem miExit;
    private MenuItem miRestart;
    private MenuItem miHighScore;
    private MenuItem miSettings;
    private MenuItem miAbout;
    private MenuItem miRules;

    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        //menuItems aanmaken:
        miExit = new MenuItem("Exit");
        miAbout = new MenuItem("About");
        miRules = new MenuItem("Rules");
        miSettings = new MenuItem("Settings");
        miHighScore = new MenuItem("Highscore");
        miRestart = new MenuItem("Restart");
    }

    private void layoutNodes() {
        //TODO menu opbouwen:

        //TODO Gridpane opbouwen en in BorderPane zetten:

    }

   //TODO getters
}
