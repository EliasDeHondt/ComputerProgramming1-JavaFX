package be.kdg.mainmenu.view;

import javafx.scene.control.Button;

public class MainMenuButton extends Button {
    public MainMenuButton(String text) {
        super(text);

        // 3.3 Zet de minimumgrootte en maximumgrootte op 240 x 80.
        this.setMinSize(240, 80);

        // 3.4 Ze de style class van de knop op “mainMenuButton”.
        this.setStyle(".mainMenuButton");
    }
}