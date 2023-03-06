package be.kdg.mywoordle.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Mijn eigen WoordleTextField, afgeleid van TextField
 */
public class WoordleTextField extends TextField {
    public WoordleTextField() {
        super.setFont(new Font(36));
        super.setPadding(new Insets(0, 0, 0, 0));
        super.setAlignment(Pos.CENTER);
        setBackground(Color.WHITE);
        super.setEditable(false);
        super.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(2))));
    }

    public void setBackground(Color color) {
        super.setBackground(new Background(new BackgroundFill(color, null, null)));
        if(color != Color.WHITE) super.setBorder(null); //enkel witte vakken hebben een border
    }

    public void setText(char c) {
        super.setText(String.valueOf(c).toUpperCase());
    }
}