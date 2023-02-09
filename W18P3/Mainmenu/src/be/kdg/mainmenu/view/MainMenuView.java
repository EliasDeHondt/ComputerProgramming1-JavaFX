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

        // Hier aanvullen...
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
