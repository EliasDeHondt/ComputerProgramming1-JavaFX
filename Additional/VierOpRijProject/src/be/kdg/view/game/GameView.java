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
    private Circle[][] circles;

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
        circles = new Circle[RIJEN][KOLOMMEN]; //6x7 circles
    }

    private void layoutNodes() {
        // menu opbouwen:
        Menu meGame = new Menu("Game",null, miSettings, miHighScore, new SeparatorMenuItem(), miRestart,miExit);
        Menu meHelp = new Menu("Help",null,miRules,miAbout);

        MenuBar menuBar = new MenuBar(meGame,meHelp);
        this.setTop(menuBar);
        // Gridpane opbouwen en in BorderPane zetten:
        GridPane gridPane = new GridPane();
        menuBar.setStyle("-fx-background-color: #9a9ad7"); //css
        gridPane.setStyle("-fx-background-color: darkblue"); //css

        for (int i = 0; i < RIJEN; i++) {
            for (int j = 0; j < KOLOMMEN; j++) {
                circles[i][j] = new Circle(25);
                circles[i][j].setFill(Color.DARKGRAY);

                gridPane.add(circles[i][j],j,i); //kolom,rij
                GridPane.setHgrow(circles[i][j],Priority.ALWAYS);
                GridPane.setVgrow(circles[i][j],Priority.ALWAYS);
            }
        }
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        setCenter(gridPane);
    }

   // getters

    Circle[][] getCircles() {
        return circles;
    }

    MenuItem getMiExit() {
        return miExit;
    }
}
