import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 * @author Elias De Hondt
 * @since 24/03/2023
 */

public class Vraag3 extends HBox {
    private static final String[] maten = { "XS", "S", "M", "XL", "XXL" };
    private RadioButton[] buttons;
    private ToggleGroup group;
    private RadioButton selectedButton;

    public Vraag3() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        buttons = new RadioButton[maten.length];
        group = new ToggleGroup();
        for (int i = 0; i < maten.length; i++) {
            buttons[i] = new RadioButton(maten[i]);
            buttons[i].setToggleGroup(group);
            if (i == 2) { // Select the middle button by default
                buttons[i].setSelected(true);
                selectedButton = buttons[i];
            }
            buttons[i].setOnMouseClicked(event -> selectedButton = (RadioButton) event.getSource());
        }
    }

    private void layoutNodes() {
        setPadding(new Insets(10));
        setSpacing(20);
        getChildren().addAll(buttons);
    }

    public RadioButton getSelectedButton() {
        return selectedButton;
    }
}
