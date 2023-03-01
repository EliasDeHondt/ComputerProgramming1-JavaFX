package be.kdg.schermen.view.start;

import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class StartView extends BorderPane {
    private Button btnNextScreen;

    public StartView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        btnNextScreen = new Button("Start ganzenbord!");
        btnNextScreen.setFont(new Font(20));
        btnNextScreen.setEffect(new Reflection());
    }

    private void layoutNodes() {
        setPrefSize(300,300);
        setCenter(btnNextScreen);
    }

    Button getBtnNextScreen() {
        return btnNextScreen;
    }
}
