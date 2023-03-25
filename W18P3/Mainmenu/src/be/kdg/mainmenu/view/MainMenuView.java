package be.kdg.mainmenu.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainMenuView extends VBox {
    private Button start;
    private Button help;
    private Button exit;

    public MainMenuView() {
        this.setMinSize(800, 600);
        this.initialiseNodes();
        this.layoutNodes();

        // 3.1 Voeg de stylesheet “style.css” toe aan deze VBox. (getStyleSheets().add( … )). Deze stylesheet kan je vinden in package be.kdg.mainmenu.view.css.
        this.getStylesheets().add("/be/kdg/mainmenu/view/css/style.css");

        // 3.2 Zet de achtergrondkleur van deze VBox op lichtblauw. (methode setStyle)
        this.setStyle("-fx-background-color: #3b83bd");
    }

    private void initialiseNodes() {
        this.start = new MainMenuButton("Start");
        this.help = new MainMenuButton("Help");
        this.exit = new MainMenuButton("Exit");
    }

    private void layoutNodes() {
        this.setPadding(new Insets(50.0, 50.0, 50.0, 50.0));
        this.setSpacing(60.0);
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(this.start);
        this.getChildren().add(this.help);
        this.getChildren().add(this.exit);
    }
}